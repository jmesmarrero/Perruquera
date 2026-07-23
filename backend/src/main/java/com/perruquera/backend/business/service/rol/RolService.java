package com.perruquera.backend.business.service.rol;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.perruquera.backend.adapters.out.persistence.rol.IRolPersistence;
import com.perruquera.backend.business.validation.ValidationRol;
import com.perruquera.backend.business.validation.ValidationUtils;
import com.perruquera.backend.entities.Rol;

@Service
public class RolService implements IRolService {

    private final IRolPersistence repo;

    public RolService(IRolPersistence repo) {
        this.repo = repo;
    }

    @Override
    public Rol save(Rol rol) {

        if (!ValidationRol.isValidRol(rol)) {
            return null;
        }

        // .isPresent para no guardar dos roles iguales
        // 1. ADMIN - 3. ADMIN (nuevamente)
        if (repo.findByNombre(rol.getNombre()).isPresent()) {
            return null;
        }

        return repo.save(rol);

    }

    @Override
    public Optional<Rol> findById(Long id) {
        if (id == null) {
            return Optional.empty();
        }

        return repo.findById(id);
    }

    @Override
    public List<Rol> findAll() {
        return repo.findAll();
    }

    @Override
    public Optional<Rol> update(Long id, Rol rol) {
        if (id == null) {
            return Optional.empty();
        }

        if (!ValidationRol.isValidRol(rol)) {
            return Optional.empty();
        }

        if (!repo.existsById(id)) {
            return Optional.empty();
        }

        rol.setId(id);

        return Optional.of(repo.save(rol));
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
    public Optional<Rol> findByNombre(String nombre) {
        if (!ValidationUtils.isValidNombre(nombre)) {
            return Optional.empty();
        }

        return repo.findByNombre(nombre);
    }

    @Override
    public Optional<Rol> patch(Long id, Rol rol) {
        if (id == null) {
            return Optional.empty();
        }

        Optional<Rol> rolOpt = repo.findById(id);

        if (rolOpt.isEmpty()) {
            return Optional.empty();
        }

        Rol rolExistente = rolOpt.get();

        if (rol.getNombre() != null) {
            rolExistente.setNombre(rol.getNombre());
        }

        return Optional.of(repo.save(rolExistente));
    }

}
