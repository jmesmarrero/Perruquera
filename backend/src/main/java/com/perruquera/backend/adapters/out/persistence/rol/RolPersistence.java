package com.perruquera.backend.adapters.out.persistence.rol;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.perruquera.backend.entities.Rol;
@Repository
public class RolPersistence implements IRolPersistence{

    private final RolJpaPersistence jpaRepo;

    public RolPersistence(RolJpaPersistence jpaRepo){
        this.jpaRepo = jpaRepo;
    }

    @Override
    public Rol save(Rol rol) {
        return jpaRepo.save(rol);
    }

    @Override
    public Optional<Rol> findById(Long id) {
        return jpaRepo.findById(id);
    }

    @Override
    public List<Rol> findAll() {
        return jpaRepo.findAll();
    }

    @Override
    public Optional<Rol> update(Long id, Rol rol) {
        if(!existsById(id)){
            return Optional.empty();
        }
        rol.setId(id);
        return Optional.of(save(rol));
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
    public Optional<Rol> findByNombre(String nombre) {
        return jpaRepo.findByNombre(nombre);
    }

}
