package com.perruquera.backend.adapters.out.persistence.horario;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.perruquera.backend.entities.DiaSemana;
import com.perruquera.backend.entities.Horario;

public interface HorarioJpaPersistence extends JpaRepository<Horario, Long> {

    /**
     * Funcion para buscar diaSemana por su nombre
     * @param diaSemana nombre del diaSemana
     * @return diaSemana ecnontrado si existe
     */
    Optional<Horario>findBydiaSemana(DiaSemana diaSemana);

}
