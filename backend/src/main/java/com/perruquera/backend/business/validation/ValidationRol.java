package com.perruquera.backend.business.validation;

import com.perruquera.backend.entities.Rol;

public final class ValidationRol {

    private ValidationRol() {
    }

    //Mejor que un Enum, proque se puede aañdir nuevo Rol en el futuro. 
    // añadir || "VETERINARIA".equals(nombre) y el el seed.sql
    private static boolean isRolPermitido(String nombre) {
        return "ADMIN".equals(nombre)
                || "EMPLEADA".equals(nombre)
                || "CLIENTE".equals(nombre);
    }

    public static boolean isValidRol(Rol rol) {
        if (rol == null) {
            return false;
        }

        return ValidationUtils.isValidNombre(rol.getNombre())
                && isRolPermitido(rol.getNombre());
    }

}
