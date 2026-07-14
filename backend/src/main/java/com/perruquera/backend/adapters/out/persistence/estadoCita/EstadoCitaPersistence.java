package com.perruquera.backend.adapters.out.persistence.estadoCita;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.perruquera.backend.entities.EstadoCita;

@Repository
public class EstadoCitaPersistence implements IEstadoCitaPersistence {

    private final EstadoCitaJpaPersistence jpaRepo;

    public EstadoCitaPersistence(EstadoCitaJpaPersistence jpaRepo) {
        this.jpaRepo = jpaRepo;
    }

    @Override
    public EstadoCita save(EstadoCita estadoCita) {
        return jpaRepo.save(estadoCita);
    }

    @Override
    public Optional<EstadoCita> findById(Long id) {
        return jpaRepo.findById(id);
    }

    @Override
    public List<EstadoCita> findAll() {
        return jpaRepo.findAll();
    }

    @Override
    public Optional<EstadoCita> update(Long id, EstadoCita estadoCita) {
        if (!existsById(id)) {
            return Optional.empty();
        }
        estadoCita.setId(id);
        return Optional.of(save(estadoCita));
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
    public Optional<EstadoCita> findByNombre(String nombre) {
        return jpaRepo.findByNombre(nombre);
    }

}
