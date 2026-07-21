package com.perruquera.backend.business.service.cita;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import com.perruquera.backend.entities.Cita;
import com.perruquera.backend.entities.EstadoCita;
import com.perruquera.backend.entities.Mascota;

public interface ICitaService {

    /**
     * Funcion para crear un nuevo cita 
     * @param cita cita que se quiere crear
     * @return cita creado
     */
    Cita save(Cita cita);

    /**
     * Funcion para encontrar el cita por su id
     * @param id identificador unico de la clase
     * @return cita encontrado por el id
     */
    Optional<Cita> findById(Long id);

    /**
     * Funcion para buscar todos los cita
     * @return lista con todos los cita
     */
    List<Cita> findAll();

    /**
     * Funcion para actualizar el cita por su id
     * @param id identificador unico de la clase
     * @param cita cita asignado 
     * @return cita actualizado
     */
    Optional<Cita> update(Long id, Cita cita);
    
    /**
     * Funcion para eliminar el cita por su id
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
     * Funcion para encontrar cita pos mascota
     * @param mascota mascota dada para buscar
     * @return mascota encontrada por su objeto
     */
   List<Cita> findByMascota(Mascota mascota);

   /**
    * Funcion para buscar cita por estados
    * @param estado estado de la cita
    * @return lista de citas por su esatdo
    */
   List<Cita> findByEstado(EstadoCita estado);

   /**
    * Funcion para buscar cita por fecha y hora
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
