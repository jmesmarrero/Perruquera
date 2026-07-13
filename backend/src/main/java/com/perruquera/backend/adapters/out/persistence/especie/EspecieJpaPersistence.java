package com.perruquera.backend.adapters.out.persistence.especie;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.perruquera.backend.entities.Especie;

public interface EspecieJpaPersistence extends JpaRepository<Especie, Long> {

    /**
     * Funcion para encontrar especie por su nombre
     * @param nombre nombre de la especie
     * @return especie encontrada por su nombre
     */
    Optional<Especie> findByNombre(String nombre);

}
