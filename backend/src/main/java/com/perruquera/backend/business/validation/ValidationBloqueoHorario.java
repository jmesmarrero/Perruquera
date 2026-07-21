package com.perruquera.backend.business.validation;

import com.perruquera.backend.entities.BloqueoHorario;

public final class ValidationBloqueoHorario {

    private ValidationBloqueoHorario(){}

    public static boolean isValidBloqueoHorario(BloqueoHorario bloqueoHorario){
        if (bloqueoHorario == null) {
            return false;
        }
        return ValidationUsuario.isValidUsuario(bloqueoHorario.getUsuario()) 
            && ValidationUtils.isValidFecha(bloqueoHorario.getFecha())
            && ValidationUtils.isValidRangoHorario(bloqueoHorario.getHoraInicio(), bloqueoHorario.getHoraFin())
            && ValidationUtils.isValidTexto(bloqueoHorario.getMotivo()); // motivo no puede ser null tiene que poner obligado motivo
        
    }
}
