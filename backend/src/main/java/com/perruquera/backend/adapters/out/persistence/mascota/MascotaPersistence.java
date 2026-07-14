package com.perruquera.backend.adapters.out.persistence.mascota;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.perruquera.backend.entities.Mascota;
import com.perruquera.backend.entities.Usuario;

@Repository
public class MascotaPersistence implements IMascotaPersistence {

    private final MascotaJpaPersistence jpaRepo;

    public MascotaPersistence(MascotaJpaPersistence jpaRepo) {
        this.jpaRepo = jpaRepo;
    }

    @Override
    public Mascota save(Mascota mascota) {
        return jpaRepo.save(mascota);
    }

    @Override
    public Optional<Mascota> findById(Long id) {
        return jpaRepo.findById(id);
    }

    @Override
    public List<Mascota> findAll() {
        return jpaRepo.findAll();
    }

    @Override
    public Optional<Mascota> update(Long id, Mascota mascota) {
        if (!existsById(id)) {
            return Optional.empty();
        }
        mascota.setId(id);
        return Optional.of(save(mascota));
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
    public List<Mascota> findByNombre(String nombre) {
        return jpaRepo.findByNombre(nombre);
    }

    @Override
    public List<Mascota> findByUsuario(Usuario usuario) {
        return jpaRepo.findByUsuario(usuario);
    }

    @Override
    public Optional<Mascota> findByUsuarioAndNombre(Usuario usuario, String nombre) {
        return jpaRepo.findByUsuarioAndNombre(usuario, nombre);
    }

}
