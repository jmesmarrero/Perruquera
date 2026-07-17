package com.perruquera.backend.business.service.usuario;

import java.util.List;
import java.util.Optional;

import com.perruquera.backend.adapters.out.persistence.usuario.IUsuarioPersistence;
import com.perruquera.backend.business.validation.ValidationUsuario;
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
        repo.deleteById(id);
    }

    @Override
    public boolean existsById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'existsById'");
    }

    @Override
    public List<Usuario> findByNombre(String nombre) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByNombre'");
    }

    @Override
    public Optional<Usuario> findByEmail(String email) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByEmail'");
    }

    @Override
    public boolean existsByEmail(String email) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'existsByEmail'");
    }

    @Override
    public Optional<Usuario> findByTelefono(String telefono) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByTelefono'");
    }

}
