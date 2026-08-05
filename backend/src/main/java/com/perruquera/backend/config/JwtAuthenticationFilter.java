package com.perruquera.backend.config;

import java.io.IOException;
import java.util.Collections;
import java.util.Optional;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.perruquera.backend.adapters.out.persistence.usuario.IUsuarioPersistence;
import com.perruquera.backend.business.service.auth.IJwtService;
import com.perruquera.backend.entities.Usuario;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final IJwtService jwtService;
    private final IUsuarioPersistence usuarioPersistence;

    public JwtAuthenticationFilter(IJwtService jwtService, IUsuarioPersistence usuarioPersistence) {
        this.jwtService = jwtService;
        this.usuarioPersistence = usuarioPersistence;
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

        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
                usuario,
                null,
                Collections.emptyList());

        SecurityContextHolder.getContext().setAuthentication(authentication);
        filterChain.doFilter(request, response);
    }

}
