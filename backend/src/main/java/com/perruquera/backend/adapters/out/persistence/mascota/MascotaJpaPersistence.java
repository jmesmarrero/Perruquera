package com.perruquera.backend.adapters.out.persistence.mascota;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.perruquera.backend.entities.Mascota;
import com.perruquera.backend.entities.Usuario;

public interface MascotaJpaPersistence extends JpaRepository<Mascota, Long> {

    /**
     * Funcion para buscar mascota por su nombre
     * @param nombre nombre de la mascota
     * @return mascota ecnontrado si existe
     */
    List<Mascota> findByNombre(String nombre);

    /**
     * Funcion para buscar mascota por su usuario
     * @param usuario usuario de las mascota
     * @return lista de mascotas por su usuario
     */
    List<Mascota> findByUsuario(Usuario usuario);

    /**
     * Funcion para buscar mascota por usuario y nombre
     * @param usuario usuario de las mascota
     * @param nombre nombre de la mascota
     * @return mascota por el usuario y su nombre
     */
    Optional<Mascota> findByUsuarioAndNombre(Usuario usuario, String nombre);


}
