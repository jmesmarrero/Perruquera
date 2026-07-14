package com.perruquera.backend.adapters.out.persistence.citaServicio;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.perruquera.backend.entities.Cita;
import com.perruquera.backend.entities.CitaServicio;
import com.perruquera.backend.entities.Servicio;

@Repository
public class CitaServicioPersistence implements ICitaServicioPersistence {

    private final CitaServicioJpaPersistence jpaRepo;

    public CitaServicioPersistence(CitaServicioJpaPersistence jpaRepo) {
        this.jpaRepo = jpaRepo;
    }

    @Override
    public CitaServicio save(CitaServicio citaServicio) {
        return jpaRepo.save(citaServicio);
    }

    @Override
    public Optional<CitaServicio> findById(Long id) {
        return jpaRepo.findById(id);
    }

    @Override
    public List<CitaServicio> findAll() {
        return jpaRepo.findAll();
    }

    @Override
    public Optional<CitaServicio> update(Long id, CitaServicio citaServicio) {
        if (!existsById(id)) {
            return Optional.empty();
        }
        citaServicio.setId(id);
        return Optional.of(save(citaServicio));
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
    public List<CitaServicio> findByCita(Cita cita) {
        return jpaRepo.findByCita(cita);
    }

    @Override
    public List<CitaServicio> findByServicio(Servicio servicio) {
        return jpaRepo.findByServicio(servicio);
    }

    @Override
    public boolean existsByCitaAndServicio(Cita cita, Servicio servicio) {
        return jpaRepo.existsByCitaAndServicio(cita, servicio);

    }

    @Override
    public Optional<CitaServicio> findByCitaAndServicio(Cita cita, Servicio servicio) {
        return jpaRepo.findByCitaAndServicio(cita, servicio);
    }

}
