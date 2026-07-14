package com.perruquera.backend.adapters.out.persistence.citaServicio;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.perruquera.backend.entities.Cita;
import com.perruquera.backend.entities.CitaServicio;
import com.perruquera.backend.entities.Servicio;

public interface CitaServicioJpaPersistence extends JpaRepository<CitaServicio, Long> {

    /**
     * Obtiene todos los servicios asociados a una cita.
     *
     * Se utiliza para consultar qué servicios se realizarán
     * durante una cita determinada.
     *
     * @param cita cita a consultar.
     * @return lista de servicios asociados a la cita.
     */
    List<CitaServicio> findByCita(Cita cita);

    /**
     * Obtiene todas las citas en las que aparece un servicio.
     *
     * Puede utilizarse para estadísticas o consultas sobre
     * la utilización de un determinado servicio.
     *
     * @param servicio servicio a consultar.
     * @return lista de relaciones cita-servicio.
     */
    List<CitaServicio> findByServicio(Servicio servicio);

    /**
     * Comprueba si una cita tiene asociado un determinado servicio.
     *
     * Es útil para evitar registrar el mismo servicio varias veces
     * dentro de una misma cita.
     *
     * @param cita cita.
     * @param servicio servicio.
     * @return true si la relación existe.
     */
    boolean existsByCitaAndServicio(Cita cita, Servicio servicio);

    /**
     * Obtiene una relación concreta entre una cita y un servicio.
     *
     * Permite recuperar la asociación cuando se conoce tanto
     * la cita como el servicio.
     *
     * @param cita cita.
     * @param servicio servicio.
     * @return relación cita-servicio si existe.
     */
    Optional<CitaServicio> findByCitaAndServicio(Cita cita, Servicio servicio);

}
