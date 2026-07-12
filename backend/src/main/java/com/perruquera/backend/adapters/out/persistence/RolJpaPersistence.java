package com.perruquera.backend.adapters.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.perruquera.backend.entities.Rol;

public interface RolJpaPersistence extends JpaRepository<Rol, Long> {

}
