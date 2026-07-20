package com.perruquera.backend.business.service.raza;

import java.util.List;
import java.util.Optional;

import com.perruquera.backend.entities.Especie;
import com.perruquera.backend.entities.Raza;

public interface IRazaService {

    /**
     * Funcion para crear un nuevo raza 
     * @param raza raza que se quiere crear
     * @return raza creado
     */
    Raza save(Raza raza);

    /**
     * Funcion para encontrar el raza por su id
     * @param id identificador unico de la clase
     * @return raza encontrado por el id
     */
    Optional<Raza> findById(Long id);

    /**
     * Funcion para buscar todos los razaes
     * @return lista con todos los razaes
     */
    List<Raza> findAll();

    /**
     * Funcion para actualizar el raza por su id
     * @param id identificador unico de la clase
     * @param raza raza asignado 
     * @return raza actualizado
     */
    Optional<Raza> update(Long id, Raza raza);
    
    /**
     * Funcion para eliminar el raza por su id
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
     * Funcion para buscar raza por su nombre
     * 
     * @param nombre nombre del raza
     * @return raza ecnontrado si existe
     */
    List<Raza> findByNombre(String nombre);

    /**
     * Funcion para encontrar la raza por su especie
     * 
     * @param especie parametro dado por la clase
     * @return raza encontrada por su especie
     */
    List<Raza> findByEspecie(Especie especie);

    /**
     * Funcion para encontrar raza por la especie y nombre
     * 
     * @param especie parametro dado por la clase
     * @param nombre  nombre de la especie
     * @return devuelve la raza opr su especie y nombre
     */
    Optional<Raza> findByEspecieAndNombre(Especie especie, String nombre);

}
