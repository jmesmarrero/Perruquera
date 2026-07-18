package com.perruquera.backend.business.service.usuario;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.perruquera.backend.adapters.out.persistence.usuario.IUsuarioPersistence;
import com.perruquera.backend.business.validation.ValidationUsuario;
import com.perruquera.backend.business.validation.ValidationUtils;
import com.perruquera.backend.entities.Usuario;

public class UsuarioService implements IUsuarioService {

    private final IUsuarioPersistence repo;

    public UsuarioService(IUsuarioPersistence repo) {
        this.repo = repo;
    }

    @Override
    public Usuario save(Usuario usuario) {
        if (!ValidationUsuario.isValidUsuario(usuario)) {
            return null;
        }
        if (repo.existsByEmail(usuario.getEmail())) {
            return null;
        }
        return repo.save(usuario);
    }

    @Override
    public Optional<Usuario> findById(Long id) {
        if (id == null) {
            return Optional.empty();
        }

        return repo.findById(id);

    }

    @Override
    public List<Usuario> findAll() {
        return repo.findAll();
    }

    @Override
    public Optional<Usuario> update(Long id, Usuario usuario) {
        if (id == null) {
            return Optional.empty();
        }
        if (!ValidationUsuario.isValidUsuario(usuario)) {
            return Optional.empty();
        }

        if (!repo.existsById(id)) {
            return Optional.empty();
        }
        usuario.setId(id);

        return Optional.of(repo.save(usuario));
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
    public List<Usuario> findByNombre(String nombre) {
        if (!ValidationUtils.isValidNombre(nombre)) {
            return new ArrayList<>();
        }
        return repo.findByNombre(nombre);
    }

    @Override
    public Optional<Usuario> findByEmail(String email) {
        if (!ValidationUtils.isValidEmail(email)) {
            return Optional.empty();
        }
        return repo.findByEmail(email);
    }

    @Override
    public boolean existsByEmail(String email) {
        if (!ValidationUtils.isValidEmail(email)) {
            return false;
        }
        return repo.existsByEmail(email);
    }

    @Override
    public Optional<Usuario> findByTelefono(String telefono) {
        if (!ValidationUtils.isValidTelefono(telefono)) {
            return Optional.empty();
        }

        return repo.findByTelefono(telefono);
    }

}
