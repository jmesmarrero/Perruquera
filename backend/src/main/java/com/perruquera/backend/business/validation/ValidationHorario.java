package com.perruquera.backend.business.validation;

import com.perruquera.backend.entities.Horario;

public final class ValidationHorario {

    private ValidationHorario() {
    }

    public static boolean isValidHorario(Horario horario) {

        if (horario == null) {
            return false;
        }

        return ValidationUtils.isValidDiaSemana(horario.getDiaSemana())
                && ValidationUtils.isValidHora(horario.getHoraApertura())
                && ValidationUtils.isValidHora(horario.getHoraCierre())
                && ValidationUtils.isValidRangoHorario(horario.getHoraApertura(), horario.getHoraCierre());
    }

}
