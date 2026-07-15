package com.perruquera.backend.adapters.out.persistence.usuarioRol;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.perruquera.backend.entities.Rol;
import com.perruquera.backend.entities.Usuario;
import com.perruquera.backend.entities.UsuarioRol;
@Repository
public class UsuarioRolPersistence implements IUsuarioRolPersistence{

    private final UsuarioRolJpaPersistence jpaRepo;

    public UsuarioRolPersistence(UsuarioRolJpaPersistence jpaRepo){
        this.jpaRepo = jpaRepo;
    }

    @Override
    public UsuarioRol save(UsuarioRol usuarioRol) {
        return jpaRepo.save(usuarioRol);
    }

    @Override
    public Optional<UsuarioRol> findById(Long id) {
        return jpaRepo.findById(id);
    }

    @Override
    public List<UsuarioRol> findAll() {
        return jpaRepo.findAll();
    }

    @Override
    public Optional<UsuarioRol> update(Long id, UsuarioRol usuarioRol) {
        if(!existsById(id)){
            return Optional.empty();
        }
        usuarioRol.setId(id);
        return Optional.of(save(usuarioRol));
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
    public List<UsuarioRol> findByUsuario(Usuario usuario) {
        return jpaRepo.findByUsuario(usuario);
    }

    @Override
    public List<UsuarioRol> findByRol(Rol rol) {
        return jpaRepo.findByRol(rol);
    }

    @Override
    public Optional<UsuarioRol> findByUsuarioAndRol(Usuario usuario, Rol rol) {
        return jpaRepo.findByUsuarioAndRol(usuario, rol);
    }

    

}
