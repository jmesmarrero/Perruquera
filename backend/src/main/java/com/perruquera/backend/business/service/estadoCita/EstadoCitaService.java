package com.perruquera.backend.business.service.estadoCita;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.perruquera.backend.adapters.out.persistence.estadoCita.IEstadoCitaPersistence;
import com.perruquera.backend.business.validation.ValidationEstadoCita;
import com.perruquera.backend.business.validation.ValidationUtils;
import com.perruquera.backend.entities.EstadoCita;


@Service
public class EstadoCitaService implements IEstadoCitaService {

    private final IEstadoCitaPersistence repo;

    public EstadoCitaService(IEstadoCitaPersistence repo) {
        this.repo = repo;
    }

    @Override
    public EstadoCita save(EstadoCita estadoCita) {
        if (!ValidationEstadoCita.isValidEstadoCita(estadoCita)) {
            return null;
        }
        
        if (repo.findByNombre(estadoCita.getNombre()).isPresent()) {
            return null;
        }
        return repo.save(estadoCita);
    }

    @Override
    public Optional<EstadoCita> findById(Long id) {
        if (id == null) {
            return Optional.empty();
        }
        return repo.findById(id);
    }

    @Override
    public List<EstadoCita> findAll() {
        return repo.findAll();
    }

    @Override
    public Optional<EstadoCita> update(Long id, EstadoCita estadoCita) {
        if (id == null) {
            return Optional.empty();
        }
        if (!ValidationEstadoCita.isValidEstadoCita(estadoCita)) {
            return Optional.empty();
        }
        if (!existsById(id)) {
            return Optional.empty();
        }
        estadoCita.setId(id);
        return Optional.of(repo.save(estadoCita));
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
    public Optional<EstadoCita> findByNombre(String nombre) {
        if (!ValidationUtils.isValidNombre(nombre)) {
            return Optional.empty();
        }
        return repo.findByNombre(nombre);
    }

}
