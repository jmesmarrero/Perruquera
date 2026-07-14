package com.perruquera.backend.adapters.out.persistence.usuario;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.perruquera.backend.entities.Usuario;

@Repository
public class UsuarioPersistence implements IUsuarioPersistence{

    private final UsuarioJpaPersistence jpaRepo;

    public UsuarioPersistence(UsuarioJpaPersistence jpaRepo){
        this.jpaRepo = jpaRepo;
    }

    @Override
    public Usuario save(Usuario usuario) {
        return jpaRepo.save(usuario);
    }

    @Override
    public Optional<Usuario> findById(Long id) {
        return jpaRepo.findById(id);
    }

    @Override
    public List<Usuario> findAll() {
        return jpaRepo.findAll();
    }

    @Override
    public Optional<Usuario> update(Long id, Usuario usuario) {
        if(!existsById(id)){
            return Optional.empty();
        }
        usuario.setId(id);
        return Optional.of(save(usuario));
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
    public List<Usuario> findByNombre(String nombre) {
        return jpaRepo.findByNombre(nombre);
    }

    @Override
    public Optional<Usuario> findByEmail(String email) {
        return jpaRepo.findByEmail(email);
    }

    @Override
    public boolean existsByEmail(String email) {
        return jpaRepo.existsByEmail(email);
    }

    @Override
    public Optional<Usuario> findByTelefono(String telefono) {
        return jpaRepo.findByTelefono(telefono);
    }

}
