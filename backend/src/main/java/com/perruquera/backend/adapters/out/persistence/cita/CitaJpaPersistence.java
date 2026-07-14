package com.perruquera.backend.adapters.out.persistence.cita;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.perruquera.backend.entities.Cita;
import com.perruquera.backend.entities.EstadoCita;
import com.perruquera.backend.entities.Mascota;

public interface CitaJpaPersistence extends JpaRepository<Cita, Long> {

    /**
     * Funcion para encontrar cita pos mascota
     * 
     * @param mascota mascota dada para buscar
     * @return mascota encontrada por su objeto
     */
    List<Cita> findByMascota(Mascota mascota);

    /**
     * Funcion para buscar cita por estados
     * 
     * @param estado estado de la cita
     * @return lista de citas por su esatdo
     */
    List<Cita> findByEstado(EstadoCita estado);

    /**
     * Funcion para buscar cita por fecha y hora
     * 
     * @param fechaHora datos dados para buscar
     * @return lista de citas por esa fecha y hora
     */
    List<Cita> findByFechaHoraBetween(LocalDateTime inicio, LocalDateTime fin);

    /**
     * Fucnion para encontrar cita por amscota en horario descendente
     * @param mascota mascota dada para buscar
     * @return listado de las mascotas en
     */
    List<Cita> findByMascotaOrderByFechaHoraDesc(Mascota mascota);

    /**
     * Funcion para buscar cita por esatdo con fechay hora Ascendente
     * @param estado estado dado para buscar
     * @return listado de estado ordenador fecha y hora ASC
     */
    List<Cita> findByEstadoOrderByFechaHoraAsc(EstadoCita estado);

}
