package com.perruquera.backend.adapters.out.persistence.servicio;

import java.util.List;
import java.util.Optional;

import com.perruquera.backend.entities.Servicio;


public interface IServicioPersistence {

    /**
     * Funcion para crear un nuevo Servicio 
     * @param servicio Servicio que se quiere crear
     * @return Servicio creado
     */
    Servicio save(Servicio servicio);

    /**
     * Funcion para encontrar el Servicio por su id
     * @param id identificador unico de la clase
     * @return Servicio encontrado por el id
     */
    Optional<Servicio> findById(Long id);

    /**
     * Funcion para buscar todos los Servicioes
     * @return lista con todos los Servicioes
     */
    List<Servicio> findAll();

    /**
     * Funcion para actualizar el Servicio por su id
     * @param id identificador unico de la clase
     * @param servicio Servicio asignado 
     * @return Servicio actualizado
     */
    Optional<Servicio> update(Long id, Servicio servicio);
    
    /**
     * Funcion para eliminar el Servicio por su id
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
