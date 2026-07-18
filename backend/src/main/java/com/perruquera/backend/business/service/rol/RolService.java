package com.perruquera.backend.business.service.rol;

import java.util.List;
import java.util.Optional;

import com.perruquera.backend.adapters.out.persistence.rol.IRolPersistence;
import com.perruquera.backend.business.validation.ValidationRol;
import com.perruquera.backend.entities.Rol;

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

        if (repo.findByNombre(rol.getNombre()).isPresent()) {
            return null;
        }

        return repo.save(rol);

    }

    @Override
    public Optional<Rol> findById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public List<Rol> findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public Optional<Rol> update(Long id, Rol rol) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void deleteById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteById'");
    }

    @Override
    public boolean existsById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'existsById'");
    }

    @Override
    public Optional<Rol> findByNombre(String nombre) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByNombre'");
    }

}
