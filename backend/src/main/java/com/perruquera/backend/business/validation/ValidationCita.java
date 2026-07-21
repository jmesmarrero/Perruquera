package com.perruquera.backend.business.validation;

import com.perruquera.backend.entities.Cita;

public final class ValidationCita {
    
    private ValidationCita() {
    }

    public static boolean isValidCita(Cita cita) {

        if (cita == null) {
            return false;
        }

        return ValidationMascota.isValidMascota(cita.getMascota())
                && ValidationEstadoCita.isValidEstadoCita(cita.getEstado())
                && ValidationUtils.isValidFechaHora(cita.getFechaHora())
                && ValidationUtils.isValidDuracion(cita.getDuracionEstimada())
                && ValidationUtils.isValidPrecio(cita.getPrecioTotal())
                && ValidationUtils.isValidFechaHora(cita.getFechaCreacion())
                && (cita.getObservaciones() == null || ValidationUtils.isValidTexto(cita.getObservaciones()));

    }
}
