package com.perruquera.backend.business.service.auth;

import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.perruquera.backend.adapters.in.auth.api.LoginRequestDTO;
import com.perruquera.backend.adapters.out.persistence.usuario.IUsuarioPersistence;
import com.perruquera.backend.entities.Usuario;

@Service
public class AuthService implements IAuthService {

    private final PasswordEncoder passwordEncoder;
    private final IUsuarioPersistence usuarioPersistence;

    public AuthService(PasswordEncoder passwordEncoder, IUsuarioPersistence usuarioPersistence) {
        this.passwordEncoder = passwordEncoder;
        this.usuarioPersistence = usuarioPersistence;
    }

    @Override
    public String login(LoginRequestDTO request) {

        Optional<Usuario> usuarioOpt = usuarioPersistence.findByEmail(request.getEmail());

        if (!usuarioOpt.isEmpty()) {
            throw new RuntimeException("Credenciales incorrectas");
        }

        Usuario usuario = usuarioOpt.get();
        if (!usuario.isActivo()) {
            throw new RuntimeException("Usuario desactivado");
        }

        if (!passwordEncoder.matches(
                request.getPassword(),
                usuario.getPasswordHash())) {

            throw new RuntimeException("Credenciales incorrectas");
        }

        return "LOGIN CORRECTO";
    }

}
