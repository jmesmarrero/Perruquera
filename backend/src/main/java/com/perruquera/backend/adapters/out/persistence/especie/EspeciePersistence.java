package com.perruquera.backend.adapters.out.persistence.especie;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.perruquera.backend.entities.Especie;

@Repository
public class EspeciePersistence implements IEspeciePersistence {

    private final EspecieJpaPersistence jpaRepo;

    public EspeciePersistence(EspecieJpaPersistence jpaRepo) {
        this.jpaRepo = jpaRepo;
    }

    @Override
    public Especie save(Especie especie) {
        return jpaRepo.save(especie);
    }

    @Override
    public Optional<Especie> findById(Long id) {
        return jpaRepo.findById(id);
    }

    @Override
    public List<Especie> findAll() {
        return jpaRepo.findAll();
    }

    @Override
    public Optional<Especie> update(Long id, Especie especie) {
        if (!existsById(id)) {
            return Optional.empty();
        }
        especie.setId(id);
        return Optional.of(save(especie));
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
    public Optional<Especie> findByNombre(String nombre) {
        return jpaRepo.findByNombre(nombre);
    }

}
