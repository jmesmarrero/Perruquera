package com.perruquera.backend.business.validation;

import com.perruquera.backend.entities.CitaServicio;

public final class ValidationCitaServicio {

    private ValidationCitaServicio() {
    }

    public static boolean isValidCitaServicio(CitaServicio citaServicio) {
        if (citaServicio == null) {
            return false;
        }

        return ValidationCita.isValidCita(citaServicio.getCita())
                && ValidationServicio.isValidServicio(citaServicio.getServicio());

    }

}
