package com.perruquera.backend.business.service.especie;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.perruquera.backend.adapters.out.persistence.especie.IEspeciePersistence;
import com.perruquera.backend.business.validation.ValidationEspecie;
import com.perruquera.backend.business.validation.ValidationUtils;
import com.perruquera.backend.entities.Especie;

@Service
public class EspecieService implements IEspecieService {

    private final IEspeciePersistence repo;

    public EspecieService(IEspeciePersistence repo) {
        this.repo = repo;
    }

    @Override
    public Especie save(Especie especie) {
        if (!ValidationEspecie.isValidEspecie(especie)) {
            return null;
        }
        if (repo.findByNombre(especie.getNombre()).isPresent()) {
            return null;

        }
        return repo.save(especie);
    }

    @Override
    public Optional<Especie> findById(Long id) {
        if (id == null) {
            return Optional.empty();
        }
        return repo.findById(id);
    }

    @Override
    public List<Especie> findAll() {
        return repo.findAll();
    }

    @Override
    public Optional<Especie> update(Long id, Especie especie) {
        if (id == null) {
            return Optional.empty();
        }
        if (!ValidationEspecie.isValidEspecie(especie)) {
            return Optional.empty();
        }
        if (!repo.existsById(id)) {
            return Optional.empty();
        }
        especie.setId(id);
        return Optional.of(repo.save(especie));
    }

    @Override
    public void deleteById(Long id) {
        if (id == null) {
            return;
        }

        if (!repo.existsById(id)) {
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
    public Optional<Especie> findByNombre(String nombre) {
        if (!ValidationUtils.isValidNombre(nombre)) {
            return Optional.empty();
        }
        return repo.findByNombre(nombre);
    }

}
