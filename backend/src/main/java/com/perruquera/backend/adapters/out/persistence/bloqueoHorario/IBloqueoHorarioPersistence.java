package com.perruquera.backend.adapters.out.persistence.bloqueoHorario;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.perruquera.backend.entities.BloqueoHorario;
import com.perruquera.backend.entities.Usuario;

public interface IBloqueoHorarioPersistence {
    /**
     * Funcion para crear un nuevo bloqueoHorario 
     * @param bloqueoHorario bloqueoHorario que se quiere crear
     * @return bloqueoHorario creado
     */
    BloqueoHorario save(BloqueoHorario bloqueoHorario);

    /**
     * Funcion para encontrar el bloqueoHorario por su id
     * @param id identificador unico de la clase
     * @return bloqueoHorario encontrado por el id
     */
    Optional<BloqueoHorario> findById(Long id);

    /**
     * Funcion para buscar todos los bloqueoHorarioes
     * @return lista con todos los bloqueoHorarioes
     */
    List<BloqueoHorario> findAll();

    /**
     * Funcion para actualizar el bloqueoHorario por su id
     * @param id identificador unico de la clase
     * @param bloqueoHorario bloqueoHorario asignado 
     * @return bloqueoHorario actualizado
     */
    Optional<BloqueoHorario> update(Long id, BloqueoHorario bloqueoHorario);
    
    /**
     * Funcion para eliminar el bloqueoHorario por su id
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
     * Obtiene todos los bloqueos horarios asociados a un usuario.
     *
     * Se utiliza para consultar el historial de bloqueos de un peluquero
     * (vacaciones, descansos, citas médicas, etc.).
     *
     * @param usuario usuario del que se desean obtener los bloqueos.
     * @return lista de bloqueos del usuario.
     */
    List<BloqueoHorario> findByUsuario(Usuario usuario);

    /**
     * Obtiene todos los bloqueos registrados para una fecha concreta.
     *
     * Puede utilizarse para consultar todos los bloqueos existentes
     * en un día determinado.
     *
     * @param fecha fecha de búsqueda.
     * @return lista de bloqueos registrados para esa fecha.
     */
    List<BloqueoHorario> findByFecha(LocalDate fecha);

    /**
     * Obtiene los bloqueos de un usuario en una fecha concreta.
     *
     * Es el método más utilizado al crear una cita, ya que permite
     * comprobar si el profesional tiene algún bloqueo ese día.
     *
     * @param usuario usuario propietario del bloqueo.
     * @param fecha fecha a consultar.
     * @return lista de bloqueos del usuario para esa fecha.
     */
    List<BloqueoHorario> findByUsuarioAndFecha(Usuario usuario, LocalDate fecha);

    /**
     * Obtiene únicamente los bloqueos activos de un usuario.
     *
     * Permite ignorar bloqueos que hayan sido desactivados sin
     * necesidad de eliminarlos de la base de datos.
     *
     * @param usuario usuario propietario de los bloqueos.
     * @return lista de bloqueos activos del usuario.
     */
    List<BloqueoHorario> findByUsuarioAndActivoTrue(Usuario usuario);

    /**
     * Obtiene los bloqueos activos de un usuario para una fecha concreta.
     *
     * Es el método recomendado para validar la disponibilidad del
     * profesional antes de crear una nueva cita.
     *
     * @param usuario usuario propietario del bloqueo.
     * @param fecha fecha a consultar.
     * @return lista de bloqueos activos para esa fecha.
     */
    List<BloqueoHorario> findByUsuarioAndFechaAndActivoTrue(Usuario usuario, LocalDate fecha);

}
