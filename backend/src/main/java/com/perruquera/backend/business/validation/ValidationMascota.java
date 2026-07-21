package com.perruquera.backend.business.validation;

import com.perruquera.backend.entities.Mascota;

public final class ValidationMascota {

    private ValidationMascota() {
    }

    public static boolean isValidMascota(Mascota mascota) {

        if (mascota == null) {
            return false;
        }
        return ValidationUsuario.isValidUsuario(mascota.getUsuario())
                && ValidationRaza.isValidRaza(mascota.getRaza())
                && ValidationUtils.isValidNombre(mascota.getNombre())
                && ValidationUtils.isValidFechaNacimiento(mascota.getFechaNacimiento())
                && ValidationUtils.isValidPeso(mascota.getPeso())
                && ValidationUtils.isValidFotoUrl(mascota.getFotoUrl())
                && (mascota.getObservaciones() == null
                || ValidationUtils.isValidTexto(mascota.getObservaciones())) // asi puede haber mascota sin observaciones
                        && mascota.getGenero() != null;

    }

}
