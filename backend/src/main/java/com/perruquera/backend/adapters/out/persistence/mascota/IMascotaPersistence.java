package com.perruquera.backend.adapters.out.persistence.mascota;

import java.util.List;
import java.util.Optional;

import com.perruquera.backend.entities.Mascota;
import com.perruquera.backend.entities.Usuario;

public interface IMascotaPersistence {
    /**
     * Funcion para crear un nuevo mascota 
     * @param mascota mascota que se quiere crear
     * @return mascota creado
     */
    Mascota save(Mascota mascota);

    /**
     * Funcion para encontrar el mascota por su id
     * @param id identificador unico de la clase
     * @return mascota encontrado por el id
     */
    Optional<Mascota> findById(Long id);

    /**
     * Funcion para buscar todos los mascotaes
     * @return lista con todos los mascotaes
     */
    List<Mascota> findAll();

    /**
     * Funcion para actualizar el mascota por su id
     * @param id identificador unico de la clase
     * @param mascota mascota asignado 
     * @return mascota actualizado
     */
    Optional<Mascota> update(Long id, Mascota mascota);
    
    /**
     * Funcion para eliminar el mascota por su id
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
