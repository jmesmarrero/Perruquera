package com.perruquera.backend.adapters.out.persistence.raza;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.perruquera.backend.entities.Especie;
import com.perruquera.backend.entities.Raza;

public interface RazaJpaPersistence extends JpaRepository<Raza, Long> {

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
