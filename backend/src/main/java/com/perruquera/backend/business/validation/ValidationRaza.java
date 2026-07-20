package com.perruquera.backend.business.validation;

import com.perruquera.backend.entities.Raza;

public final class ValidationRaza {

    private ValidationRaza() {
    }

    public static boolean isValidRaza(Raza raza) {

        if (raza == null) {
            return false;
        }

        return ValidationUtils.isValidNombre(raza.getNombre()) && raza.getEspecie() != null;

    }

}
