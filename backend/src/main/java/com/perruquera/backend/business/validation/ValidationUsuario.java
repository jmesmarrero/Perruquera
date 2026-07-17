package com.perruquera.backend.business.validation;

import com.perruquera.backend.entities.Usuario;

public class ValidationUsuario {

    private ValidationUsuario() {
    }

    public static boolean isValidUsuario(Usuario usuario) {
        if (usuario == null) {
            return false;
        }

        return ValidationUtils.isValidNombre(usuario.getNombre())
                && ValidationUtils.isValidApellido(usuario.getApellidos())
                && ValidationUtils.isValidTelefono(usuario.getTelefono())
                && ValidationUtils.isValidEmail(usuario.getEmail())
                && ValidationUtils.isValidPassword(usuario.getPasswordHash())
                && ValidationUtils.isValidFechaHora(usuario.getFechaRegistro());

    }

}
