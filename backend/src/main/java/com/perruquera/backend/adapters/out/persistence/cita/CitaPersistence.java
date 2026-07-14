package com.perruquera.backend.adapters.out.persistence.cita;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.perruquera.backend.entities.Cita;
import com.perruquera.backend.entities.EstadoCita;
import com.perruquera.backend.entities.Mascota;

@Repository
public class CitaPersistence implements ICitaPersistence {

    private final CitaJpaPersistence jpaRepo;

    public CitaPersistence(CitaJpaPersistence jpaRepo) {
        this.jpaRepo = jpaRepo;
    }

    @Override
    public Cita save(Cita cita) {
        return jpaRepo.save(cita);
    }

    @Override
    public Optional<Cita> findById(Long id) {
        return jpaRepo.findById(id);
    }

    @Override
    public List<Cita> findAll() {
        return jpaRepo.findAll();
    }

    @Override
    public Optional<Cita> update(Long id, Cita cita) {
        if (!existsById(id)) {
            return Optional.empty();
        }
        cita.setId(id);
        return Optional.of(save(cita));
    }

    @Override
    public void deleteById(Long id) {
        jpaRepo.deleteById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return jpaRepo.existsById(id);
    }

    @Override
    public List<Cita> findByMascota(Mascota mascota) {
        return jpaRepo.findByMascota(mascota);
    }

    @Override
    public List<Cita> findByEstado(EstadoCita estado) {
        return jpaRepo.findByEstado(estado);
    }

    @Override
    public List<Cita> findByFechaHoraBetween(LocalDateTime inicio, LocalDateTime fin) {
        return jpaRepo.findByFechaHoraBetween(inicio, fin);
    }

    @Override
    public List<Cita> findByMascotaOrderByFechaHoraDesc(Mascota mascota) {
        return jpaRepo.findByMascotaOrderByFechaHoraDesc(mascota);
    }

    @Override
    public List<Cita> findByEstadoOrderByFechaHoraAsc(EstadoCita estado) {
        return jpaRepo.findByEstadoOrderByFechaHoraAsc(estado);
    }

}
