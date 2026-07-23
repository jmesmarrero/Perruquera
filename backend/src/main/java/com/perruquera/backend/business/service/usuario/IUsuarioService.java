package com.perruquera.backend.business.service.usuario;

import java.util.List;
import java.util.Optional;

import com.perruquera.backend.adapters.in.usuario.api.UsuarioRequestDTO;
import com.perruquera.backend.entities.Usuario;

public interface IUsuarioService {

    /**
     * Funcion para crear un nuevo usuario
     * 
     * @param usuario usuario que se quiere crear
     * @return usuario creado
     */
    Usuario save(Usuario usuario);

    /**
     * Funcion para encontrar el usuario por su id
     * 
     * @param id identificador unico de la clase
     * @return usuario encontrado por el id
     */
    Optional<Usuario> findById(Long id);

    /**
     * Funcion para buscar todos los usuarioes
     * 
     * @return lista con todos los usuarioes
     */
    List<Usuario> findAll();

    /**
     * Funcion para actualizar el usuario por su id
     * 
     * @param id      identificador unico de la clase
     * @param usuario usuario asignado
     * @return usuario actualizado
     */
    Optional<Usuario> update(Long id, Usuario usuario);

    /**
     * Funcion para eliminar el usuario por su id
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
     * Funcion para buscar usuario por su nombre
     * 
     * @param nombre nombre del usuario
     * @return usuaruio ecnontrado si existe
     */
    List<Usuario> findByNombre(String nombre);

    /**
     * Funcion para encontrar usuario por email unico
     * 
     * @param email email dado por el objeto
     * @return usuario encontrado por su email
     */
    Optional<Usuario> findByEmail(String email);

    /**
     * 
     * Funcion para saber sie xiste usuario por email
     * 
     * @param email email dado por el objeto
     * @return true si existe o false enc aso contrario
     */
    boolean existsByEmail(String email);

    /**
     * Funcion para encontar usuario por su telefono
     * 
     * @param telefono tgelefono dado por el objeto
     * @return usuario encontrado por su telefono
     */
    Optional<Usuario> findByTelefono(String telefono);

    Optional<Usuario> patch(Long id, Usuario usuario);

}
