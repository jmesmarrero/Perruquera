package com.perruquera.backend.business.validation;

import com.perruquera.backend.entities.Servicio;

public final class ValidationServicio {

    private ValidationServicio() {
    }

    public static boolean isValidServicio(Servicio servicio) {
        if (servicio == null) {
            return false;
        }

        return ValidationUtils.isValidNombre(servicio.getNombre())
                && ValidationUtils.isValidTexto(servicio.getDescripcion())
                && ValidationUtils.isValidPrecio(servicio.getPrecio())
                && ValidationUtils.isValidDuracion(servicio.getDuracionEstimada());

    }

}
