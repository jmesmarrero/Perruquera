package com.perruquera.backend.business.service.usuarioRol;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.perruquera.backend.adapters.out.persistence.usuarioRol.IUsuarioRolPersistence;
import com.perruquera.backend.business.validation.ValidationRol;
import com.perruquera.backend.business.validation.ValidationUsuario;
import com.perruquera.backend.business.validation.ValidationUsuarioRol;
import com.perruquera.backend.entities.Rol;
import com.perruquera.backend.entities.Usuario;
import com.perruquera.backend.entities.UsuarioRol;

@Service
public class UsuarioRolService implements IUsuarioRolService {

    private final IUsuarioRolPersistence repo;

    public UsuarioRolService(IUsuarioRolPersistence repo) {
        this.repo = repo;
    }

    @Override
    public UsuarioRol save(UsuarioRol usuarioRol) {
        if (!ValidationUsuarioRol.isValidUsuarioRol(usuarioRol)) {
            return null;
        }
        if (repo.findByUsuarioAndRol(usuarioRol.getUsuario(), usuarioRol.getRol()).isPresent()) {
            return null;
        }
        return repo.save(usuarioRol);
    }

    @Override
    public Optional<UsuarioRol> findById(Long id) {
        if (id == null) {
            return Optional.empty();
        }
        return repo.findById(id);
    }

    @Override
    public List<UsuarioRol> findAll() {
        return repo.findAll();
    }

    @Override
    public Optional<UsuarioRol> update(Long id, UsuarioRol usuarioRol) {
        if (id == null) {
            return Optional.empty();
        }
        if (!ValidationUsuarioRol.isValidUsuarioRol(usuarioRol)) {
            return Optional.empty();
        }
        if (!existsById(id)) {
            return Optional.empty();
        }
        usuarioRol.setId(id);

        return Optional.of(repo.save(usuarioRol));
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
    public List<UsuarioRol> findByUsuario(Usuario usuario) {
        if (!ValidationUsuario.isValidUsuario(usuario)) {
            return new ArrayList<>();
        }
        return repo.findByUsuario(usuario);
    }

    @Override
    public List<UsuarioRol> findByRol(Rol rol) {
        if (!ValidationRol.isValidRol(rol)) {
            return new ArrayList<>();
        }
        return repo.findByRol(rol);
    }

    @Override
    public Optional<UsuarioRol> findByUsuarioAndRol(Usuario usuario, Rol rol) {
        if (!ValidationUsuario.isValidUsuario(usuario)) {
            return Optional.empty();
        }

        if (!ValidationRol.isValidRol(rol)) {
            return Optional.empty();
        }
        return repo.findByUsuarioAndRol(usuario, rol);
    }

}
