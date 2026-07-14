package com.perruquera.backend.adapters.out.persistence.servicio;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Repository;

import com.perruquera.backend.entities.Servicio;

@Repository
public class ServicioPersistence implements IServicioPersistence {

    private final ServicioJpaPersistence jpaRepo;

    public ServicioPersistence (ServicioJpaPersistence jpaRepo){
        this.jpaRepo = jpaRepo;
    }

    @Override
    public Servicio save(Servicio servicio) {
        return jpaRepo.save(servicio);
    }

    @Override
    public Optional<Servicio> findById(Long id) {
        return jpaRepo.findById(id);
    }

    @Override
    public List<Servicio> findAll() {
        return jpaRepo.findAll();
        
    }

    @Override
    public Optional<Servicio> update(Long id, Servicio servicio) {
        if (!existsById(id)) {
            return Optional.empty();

        }
        servicio.setId(id);
        return Optional.of(save(servicio));
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
    public Optional<Servicio> findByNombre(String nombre) {
        return jpaRepo.findByNombre(nombre);
    }

    @Override
    public List<Servicio> findByActivoTrue() {
        return jpaRepo.findByActivoTrue();
    }

   
}
