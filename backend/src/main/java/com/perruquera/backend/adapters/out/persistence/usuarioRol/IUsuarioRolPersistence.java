package com.perruquera.backend.adapters.out.persistence.usuarioRol;

import java.util.List;
import java.util.Optional;

import com.perruquera.backend.entities.Rol;
import com.perruquera.backend.entities.Usuario;
import com.perruquera.backend.entities.UsuarioRol;

public interface IUsuarioRolPersistence {
    /**
     * Funcion para crear un nuevo usuarioRol 
     * @param usuarioRol usuarioRol que se quiere crear
     * @return usuarioRol creado
     */
    UsuarioRol save(UsuarioRol usuarioRol);

    /**
     * Funcion para encontrar el usuarioRol por su id
     * @param id identificador unico de la clase
     * @return usuarioRol encontrado por el id
     */
    Optional<UsuarioRol> findById(Long id);

    /**
     * Funcion para buscar todos los usuarioRoles
     * @return lista con todos los usuarioRoles
     */
    List<UsuarioRol> findAll();

    /**
     * Funcion para actualizar el usuarioRol por su id
     * @param id identificador unico de la clase
     * @param usuarioRol usuarioRol asignado 
     * @return usuarioRol actualizado
     */
    Optional<UsuarioRol> update(Long id, UsuarioRol usuarioRol);
    
    /**
     * Funcion para eliminar el usuarioRol por su id
     * @param id identificador unico de la clase
     */
    void deleteById(Long id);

    /**
     * Funcion para comprobar si existe
     * @param id identificador unico de la clase
     * @return true si existe or false si no existe
     */
    boolean existsById(Long id);

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
