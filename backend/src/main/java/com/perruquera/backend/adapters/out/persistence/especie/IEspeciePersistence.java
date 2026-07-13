package com.perruquera.backend.adapters.out.persistence.especie;

import java.util.List;
import java.util.Optional;

import com.perruquera.backend.entities.Especie;

public interface IEspeciePersistence {

    /**
     * Funcion para crear una especie
     * @param especie especie que se quiere crear
     * @return especie creada
     */
    Especie save(Especie especie);

    /**
     * Funcion para encontrar especie por id
     * @param id identificador unico de la clase
     * @return especie encontradas por id
     */
    Optional<Especie> findById(Long id);

    /**
     * Funcion para encontrar todas las especies
     * @return lista de todas las especies
     */
    List<Especie> findAll();
    
    /**
     * Funcion para actualizar una especie
     * @param id identificador unico de la clase
     * @param especie especie para actualizar
     * @return especie actualizada
     */
    Optional<Especie> update(Long id, Especie especie);

    /**
     * Funcion para eliminar una especie
     * @param id identificador unico de la clase
     */
    void deleteById(Long id);

    /**
     * Fucnion para saber si existe la especie por ese id
     * @param id identificador unico de la clase
     * @return true si existe and false en caso contrario
     */
    boolean existsById(Long id);

    /**
     * Funcion para encontrar especie por su nombre
     * @param nombre nombre de la especie
     * @return especie encontrada por su nombre
     */
    Optional<Especie> findByNombre(String nombre);

}
