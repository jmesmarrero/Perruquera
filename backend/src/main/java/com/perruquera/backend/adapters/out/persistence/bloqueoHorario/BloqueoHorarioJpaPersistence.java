package com.perruquera.backend.adapters.out.persistence.bloqueoHorario;


import org.springframework.data.jpa.repository.JpaRepository;

import com.perruquera.backend.entities.BloqueoHorario;
import com.perruquera.backend.entities.Usuario;

import java.util.List;
import java.time.LocalDate;



public interface BloqueoHorarioJpaPersistence extends JpaRepository<BloqueoHorario, Long> {

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
