package com.perruquera.backend.adapters.out.persistence.usuario;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.perruquera.backend.entities.Usuario;

public interface UsuarioJpaPersistence extends JpaRepository<Usuario, Long> {

    /**
     * Funcion para buscar usuario por su nombre
     * @param nombre nombre del usuario
     * @return usuaruio ecnontrado si existe
     */
    List<Usuario>findByNombre(String nombre);

    /**
     * Funcion para encontrar usuario por email unico
     * @param email email dado por el objeto
     * @return usuario encontrado por su email
     */
    Optional<Usuario> findByEmail(String email);
    /**
     * 
     * Funcion para saber sie xiste usuario por email
     * @param email email dado por el objeto
     * @return true si existe o false enc aso contrario
     */
    boolean existsByEmail(String email);

    /**
     * Funcion para encontar usuario por su telefono
     * @param telefono tgelefono dado por el objeto
     * @return usuario encontrado por su telefono
     */
    Optional<Usuario> findByTelefono(String telefono);

}
