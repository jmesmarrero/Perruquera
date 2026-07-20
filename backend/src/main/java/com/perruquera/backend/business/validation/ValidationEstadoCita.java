package com.perruquera.backend.business.validation;

import com.perruquera.backend.entities.EstadoCita;

public final class ValidationEstadoCita {

    private ValidationEstadoCita() {
    }

    private static boolean isEstadoCitaPermitida(String nombre) {

        return "PENDIENTE".equals(nombre)
                || "CONFIRMADA".equals(nombre)
                || "EN PROCESO".equals(nombre)
                || "COMPLETADA".equals(nombre)
                || "CANCELADA".equals(nombre)
                || "NO PRESENTADA".equals(nombre);
    }

    public static boolean isValidEstadoCita(EstadoCita estadoCita) {
        if (estadoCita == null) {
            return false;
        }

        return ValidationUtils.isValidNombre(estadoCita.getNombre())
                && isEstadoCitaPermitida(estadoCita.getNombre());
    }

}
