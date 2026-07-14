package com.perruquera.backend.adapters.out.persistence.raza;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.perruquera.backend.entities.Especie;
import com.perruquera.backend.entities.Raza;

@Repository
public class RazaPersistence implements IRazaPersistence {

    private final RazaJpaPersistence jpaRepo;

    public RazaPersistence(RazaJpaPersistence jpaRepo) {
        this.jpaRepo = jpaRepo;
    }

    @Override
    public Raza save(Raza raza) {
        return jpaRepo.save(raza);
    }

    @Override
    public Optional<Raza> findById(Long id) {
        return jpaRepo.findById(id);
    }

    @Override
    public List<Raza> findAll() {
        return jpaRepo.findAll();
    }

    @Override
    public Optional<Raza> update(Long id, Raza raza) {
        if (!existsById(id)) {
            return Optional.empty();
        }
        raza.setId(id);
        return Optional.of(save(raza));
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
    public List<Raza> findByNombre(String nombre) {
        return jpaRepo.findByNombre(nombre);
    }

    @Override
    public List<Raza> findByEspecie(Especie especie) {
        return jpaRepo.findByEspecie(especie);
    }

    @Override
    public Optional<Raza> findByEspecieAndNombre(Especie especie, String nombre) {
        return jpaRepo.findByEspecieAndNombre(especie, nombre);
    }

}
