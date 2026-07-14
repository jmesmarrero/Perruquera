package com.perruquera.backend.adapters.out.persistence.horario;

import java.util.List;
import java.util.Optional;

import com.perruquera.backend.entities.DiaSemana;
import com.perruquera.backend.entities.Horario;

public interface IHorarioPersistence {
    /**
     * Funcion para crear un nuevo horario 
     * @param horario horario que se quiere crear
     * @return horario creado
     */
    Horario save(Horario horario);

    /**
     * Funcion para encontrar el horario por su id
     * @param id identificador unico de la clase
     * @return horario encontrado por el id
     */
    Optional<Horario> findById(Long id);

    /**
     * Funcion para buscar todos los horarioes
     * @return lista con todos los horarioes
     */
    List<Horario> findAll();

    /**
     * Funcion para actualizar el horario por su id
     * @param id identificador unico de la clase
     * @param horario horario asignado 
     * @return horario actualizado
     */
    Optional<Horario> update(Long id, Horario horario);
    
    /**
     * Funcion para eliminar el horario por su id
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
     * Funcion para buscar diaSemana por su nombre
     * @param diaSemana nombre del diaSemana
     * @return diaSemana ecnontrado si existe
     */
    Optional<Horario>findBydiaSemana(DiaSemana diaSemana);

}
