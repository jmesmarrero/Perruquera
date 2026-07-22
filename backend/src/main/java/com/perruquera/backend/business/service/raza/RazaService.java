package com.perruquera.backend.business.service.raza;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.perruquera.backend.adapters.out.persistence.raza.IRazaPersistence;
import com.perruquera.backend.business.validation.ValidationEspecie;
import com.perruquera.backend.business.validation.ValidationRaza;
import com.perruquera.backend.business.validation.ValidationUtils;
import com.perruquera.backend.entities.Especie;
import com.perruquera.backend.entities.Raza;

@Service
public class RazaService implements IRazaService {

    private final IRazaPersistence repo;

    public RazaService(IRazaPersistence repo) {
        this.repo = repo;
    }

    @Override
    public Raza save(Raza raza) {
        if (!ValidationRaza.isValidRaza(raza)) {
            return null;
        }
        if (repo.findByEspecieAndNombre(raza.getEspecie(), raza.getNombre()).isPresent()) {
            return null;

        }
        return repo.save(raza);
    }

    @Override
    public Optional<Raza> findById(Long id) {
        if (id == null) {
            return Optional.empty();
        }
        return repo.findById(id);
    }

    @Override
    public List<Raza> findAll() {
        return repo.findAll();
    }

    @Override
    public Optional<Raza> update(Long id, Raza raza) {
        if (id == null) {
            return Optional.empty();
        }
        if (!ValidationRaza.isValidRaza(raza)) {
            return Optional.empty();
        }
        if (!existsById(id)) {
            return Optional.empty();
        }
        raza.setId(id);
        return Optional.of(repo.save(raza));
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
    public List<Raza> findByNombre(String nombre) {
        if (!ValidationUtils.isValidNombre(nombre)) {
            return new ArrayList<>();
        }
        return repo.findByNombre(nombre);
    }

    @Override
    public List<Raza> findByEspecie(Especie especie) {
        if (!ValidationEspecie.isValidEspecie(especie)) {
            return new ArrayList<>();
        }
        return repo.findByEspecie(especie);
    }

    @Override
    public Optional<Raza> findByEspecieAndNombre(Especie especie, String nombre) {
        if (!ValidationEspecie.isValidEspecie(especie)) {
            return Optional.empty();
        }
        if (!ValidationUtils.isValidNombre(nombre)) {
            return Optional.empty();
        }
        return repo.findByEspecieAndNombre(especie, nombre);

    }

}
