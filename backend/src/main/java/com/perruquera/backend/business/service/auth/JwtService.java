package com.perruquera.backend.business.service.auth;

import com.perruquera.backend.entities.Usuario;

public class JwtService implements IJwtService {

    @Override
    public String generateToken(Usuario Usuario) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'generateToken'");
    }

    @Override
    public String extractEmail(String token) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'extractEmail'");
    }

    @Override
    public boolean isTokenValid(String token, Usuario usuario) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isTokenValid'");
    }

}
