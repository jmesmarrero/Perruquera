package com.perruquera.backend.adapters.out.persistence.rol;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.perruquera.backend.entities.Rol;

public interface RolJpaPersistence extends JpaRepository<Rol, Long> {

    /**
     * Funcion para buscar rol por su nombre
     * @param nombre nombre del rol
     * @return rol ecnontrado si existe
     */
    Optional<Rol>findByNombre(String nombre);

}
