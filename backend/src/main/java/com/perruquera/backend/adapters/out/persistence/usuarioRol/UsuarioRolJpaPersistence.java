package com.perruquera.backend.adapters.out.persistence.usuarioRol;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.perruquera.backend.entities.Rol;
import com.perruquera.backend.entities.Usuario;
import com.perruquera.backend.entities.UsuarioRol;

public interface UsuarioRolJpaPersistence extends JpaRepository<UsuarioRol, Long> {

    /**
 * Funcion para buscar todos los roles asignados a un usuario
 * @param usuario usuario dado para buscar
 * @return lista de roles asignados al usuario
 */
List<UsuarioRol> findByUsuario(Usuario usuario);

/**
 * Funcion para buscar todos los usuarios que tienen un rol determinado
 * @param rol rol dado para buscar
 * @return lista de usuarios con ese rol
 */
List<UsuarioRol> findByRol(Rol rol);

/**
 * Funcion para buscar la relacion entre un usuario y un rol
 * @param usuario usuario dado para buscar
 * @param rol rol dado para buscar
 * @return relacion usuario-rol encontrada si existe
 */
Optional<UsuarioRol> findByUsuarioAndRol(Usuario usuario, Rol rol);

}
