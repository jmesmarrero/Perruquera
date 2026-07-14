package com.perruquera.backend.adapters.out.persistence.estadoCita;

import java.util.List;
import java.util.Optional;

import com.perruquera.backend.entities.EstadoCita;

public interface IEstadoCitaPersistence {

    /**
     * Funcion para crear un nuevo estadoCita 
     * @param estadoCita estadoCita que se quiere crear
     * @return estadoCita creado
     */
    EstadoCita save(EstadoCita estadoCita);

    /**
     * Funcion para encontrar el estadoCita por su id
     * @param id identificador unico de la clase
     * @return estadoCita encontrado por el id
     */
    Optional<EstadoCita> findById(Long id);

    /**
     * Funcion para buscar todos los estadoCitaes
     * @return lista con todos los estadoCitaes
     */
    List<EstadoCita> findAll();

    /**
     * Funcion para actualizar el estadoCita por su id
     * @param id identificador unico de la clase
     * @param estadoCita estadoCita asignado 
     * @return estadoCita actualizado
     */
    Optional<EstadoCita> update(Long id, EstadoCita estadoCita);
    
    /**
     * Funcion para eliminar el estadoCita por su id
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
     * Funcion para buscar estadoCita por su nombre
     * @param nombre nombre del estadoCita
     * @return estadoCita ecnontrado si existe
     */
    Optional<EstadoCita> findByNombre(String nombre);

}
