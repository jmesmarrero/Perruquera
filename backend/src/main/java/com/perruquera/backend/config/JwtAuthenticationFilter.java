package com.perruquera.backend.config;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.perruquera.backend.adapters.out.persistence.usuario.IUsuarioPersistence;
import com.perruquera.backend.adapters.out.persistence.usuarioRol.IUsuarioRolPersistence;
import com.perruquera.backend.business.service.auth.IJwtService;
import com.perruquera.backend.entities.Usuario;
import com.perruquera.backend.entities.UsuarioRol;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final IJwtService jwtService;
    private final IUsuarioPersistence usuarioPersistence;
    private final IUsuarioRolPersistence usuarioRolPersistence;

    public JwtAuthenticationFilter(IJwtService jwtService, IUsuarioPersistence usuarioPersistence,
            IUsuarioRolPersistence usuarioRolPersistence) {
        this.jwtService = jwtService;
        this.usuarioPersistence = usuarioPersistence;
        this.usuarioRolPersistence = usuarioRolPersistence;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        String authHeader = request.getHeader("Authorization");

        if (authHeader == null) {
            filterChain.doFilter(request, response);
            return;
        }

        if (!authHeader.startsWith("Bearer ")) {
            filterChain.doFilter(request, response);
            return;
        }

        String jwt = authHeader.substring(7);

        String email = jwtService.extractEmail(jwt);

        Optional<Usuario> usuarioOpt = usuarioPersistence.findByEmail(email);

        if (usuarioOpt.isEmpty()) {
            filterChain.doFilter(request, response);
            return;
        }
        Usuario usuario = usuarioOpt.get();

        if (!jwtService.isTokenValid(jwt, usuario)) {
            filterChain.doFilter(request, response);
            return;
        }

        List<UsuarioRol> usuarioRoles = usuarioRolPersistence.findByUsuario(usuario);
        List<GrantedAuthority> authorities = new ArrayList<>();

        for (UsuarioRol usuarioRol : usuarioRoles) {

            authorities.add(
                    new SimpleGrantedAuthority(
                            "ROLE_" + usuarioRol.getRol().getNombre()));

        }

        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
                usuario,
                null,
                authorities);

        SecurityContextHolder.getContext().setAuthentication(authentication);
        filterChain.doFilter(request, response);
    }

}
