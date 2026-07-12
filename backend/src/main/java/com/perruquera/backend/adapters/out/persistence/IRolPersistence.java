package com.perruquera.backend.adapters.out.persistence;

import java.util.List;
import java.util.Optional;

import com.perruquera.backend.entities.Rol;

public interface IRolPersistence {

    Rol save(Rol rol);

    Optional<Rol> findById(Long id);

    List<Rol> findAll();

    Optional<Rol> update(Long id, Rol rol);

    void deleteById(Long id);

    boolean existsById(Long id);

}
