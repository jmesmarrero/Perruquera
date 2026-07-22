package com.perruquera.backend.business.service.servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.perruquera.backend.adapters.out.persistence.servicio.IServicioPersistence;
import com.perruquera.backend.business.validation.ValidationServicio;
import com.perruquera.backend.business.validation.ValidationUtils;
import com.perruquera.backend.entities.Servicio;

@Service
public class ServicioService implements IServicioService {

    private final IServicioPersistence repo;

    public ServicioService(IServicioPersistence repo) {
        this.repo = repo;
    }

    @Override
    public Servicio save(Servicio servicio) {
        if (!ValidationServicio.isValidServicio(servicio)) {
            return null;
        }
        if (repo.findByNombre(servicio.getNombre()).isPresent()) {
            return null;
        }
        return repo.save(servicio);
    }

    @Override
    public Optional<Servicio> findById(Long id) {
        if (id == null) {
            return Optional.empty();
        }
        return repo.findById(id);
    }

    @Override
    public List<Servicio> findAll() {
        return repo.findAll();
    }

    @Override
    public Optional<Servicio> update(Long id, Servicio servicio) {
        if (id == null) {
            return Optional.empty();
        }
        if (!ValidationServicio.isValidServicio(servicio)) {
            return Optional.empty();
        }
        if (!existsById(id)) {
            return Optional.empty();
        }

        servicio.setId(id);
        return Optional.of(repo.save(servicio));

    }

    @Override
    public void deleteById(Long id) {
        if (id == null) {
            return;
        }
        if (!existsById(id)) {
            return;
        }
        repo.deleteById(id);
    }

    @Override
    public boolean existsById(Long id) {
        if (id == null) {
            return false;
        }
        return repo.existsById(id);
    }

    @Override
    public Optional<Servicio> findByNombre(String nombre) {
        if (!ValidationUtils.isValidNombre(nombre)) {
            return Optional.empty();
        }
        return repo.findByNombre(nombre);
    }

    @Override
    public List<Servicio> findByActivoTrue() {
        return repo.findByActivoTrue();
    }

}
