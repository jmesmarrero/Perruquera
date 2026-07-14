package com.perruquera.backend.adapters.out.persistence.servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.perruquera.backend.entities.Servicio;

public interface ServicioJpaPersistence extends JpaRepository<Servicio, Long> {

    /**
     * Funcion para buscar servicio por su nombre
     * 
     * @param nombre nombre del servicio
     * @return servicio ecnontrado si existe
     */
    Optional<Servicio> findByNombre(String nombre);

    /**
     * Funcion para encontrar servicios activos
     * @return lista de servicios activos
     */
    List<Servicio> findByActivoTrue();

}
