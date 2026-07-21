package com.perruquera.backend.business.validation;

import com.perruquera.backend.entities.UsuarioRol;

public final class ValidationUsuarioRol {

    private ValidationUsuarioRol() {
    }

    public static boolean isValidUsuarioRol(UsuarioRol usuarioRol) {
        if (usuarioRol == null) {
            return false;
        }

        return ValidationUsuario.isValidUsuario(usuarioRol.getUsuario())
                && ValidationRol.isValidRol(usuarioRol.getRol());
    }

}
