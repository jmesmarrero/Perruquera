package com.perruquera.backend.business.service.rol;

import java.util.List;
import java.util.Optional;

import com.perruquera.backend.entities.Rol;

public interface IRolService {

    /**
     * Funcion para crear un nuevo rol
     * 
     * @param rol rol que se quiere crear
     * @return rol creado
     */
    Rol save(Rol rol);

    /**
     * Funcion para encontrar el rol por su id
     * 
     * @param id identificador unico de la clase
     * @return rol encontrado por el id
     */
    Optional<Rol> findById(Long id);

    /**
     * Funcion para buscar todos los roles
     * 
     * @return lista con todos los roles
     */
    List<Rol> findAll();

    /**
     * Funcion para actualizar el rol por su id
     * 
     * @param id  identificador unico de la clase
     * @param rol rol asignado
     * @return rol actualizado
     */
    Optional<Rol> update(Long id, Rol rol);

    /**
     * Funcion para eliminar el rol por su id
     * 
     * @param id identificador unico de la clase
     */
    void deleteById(Long id);

    /**
     * Funcion para comprobar si existe
     * 
     * @param id identificador unico de la clase
     * @return true si existe or false si no existe
     */
    boolean existsById(Long id);

    /**
     * Funcion para buscar rol por su nombre
     * 
     * @param nombre nombre del rol
     * @return rol ecnontrado si existe
     */
    Optional<Rol> findByNombre(String nombre);

    /**
     * Actualiza parcialmente un rol existente.
     * Solo se modificarán los campos que contengan un valor distinto de null.
     *
     * @param id  identificador único del rol
     * @param rol objeto con los campos que se desean actualizar
     * @return rol actualizado si existe; Optional.empty() en caso contrario
     */
    Optional<Rol> patch(Long id, Rol rol);

}
