package com.perruquera.backend.business.validation;

import com.perruquera.backend.entities.Especie;

public final class ValidationEspecie {

    private ValidationEspecie(){}

    //Mejor que un Enum, proque se puede añdir nueva especie en el futuro. 
    // añadir || "CONEJO".equals(nombre) y el el seed.sql
    private static boolean isEspeciePermitida(String nombre) {
    return "PERRO".equals(nombre)
            || "GATO".equals(nombre)
            || "OTROS".equals(nombre);
}

    public static boolean isValidEspecie(Especie especie){
        if (especie == null) {
            return false;
        }

        return ValidationUtils.isValidNombre(especie.getNombre()) && isEspeciePermitida(especie.getNombre());
        
    }
}
