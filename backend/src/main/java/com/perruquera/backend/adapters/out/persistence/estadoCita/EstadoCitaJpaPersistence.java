package com.perruquera.backend.adapters.out.persistence.estadoCita;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.perruquera.backend.entities.EstadoCita;

public interface EstadoCitaJpaPersistence extends JpaRepository<EstadoCita, Long>{

    /**
     * Funcion para buscar EstadoCita por su nombre
     * @param nombre nombre del estadoCita
     * @return EsatdoCita ecnontrado si existe
     */
    Optional<EstadoCita>findByNombre(String nombre);

}
