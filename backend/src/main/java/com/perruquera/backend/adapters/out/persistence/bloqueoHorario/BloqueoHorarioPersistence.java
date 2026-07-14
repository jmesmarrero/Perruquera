package com.perruquera.backend.adapters.out.persistence.bloqueoHorario;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.perruquera.backend.entities.BloqueoHorario;
import com.perruquera.backend.entities.Usuario;

@Repository
public class BloqueoHorarioPersistence implements IBloqueoHorarioPersistence {

    private final BloqueoHorarioJpaPersistence jpaRepo;

    public BloqueoHorarioPersistence(BloqueoHorarioJpaPersistence jpaRepo) {
        this.jpaRepo = jpaRepo;
    }

    @Override
    public BloqueoHorario save(BloqueoHorario bloqueoHorario) {
        return jpaRepo.save(bloqueoHorario);
    }

    @Override
    public Optional<BloqueoHorario> findById(Long id) {
        return jpaRepo.findById(id);
    }

    @Override
    public List<BloqueoHorario> findAll() {
        return jpaRepo.findAll();
    }

    @Override
    public Optional<BloqueoHorario> update(Long id, BloqueoHorario bloqueoHorario) {
        if (!existsById(id)) {
            return Optional.empty();
        }
        bloqueoHorario.setId(id);
        return Optional.of(save(bloqueoHorario));
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
    public List<BloqueoHorario> findByUsuario(Usuario usuario) {
        return jpaRepo.findByUsuario(usuario);
    }

    @Override
    public List<BloqueoHorario> findByFecha(LocalDate fecha) {
        return jpaRepo.findByFecha(fecha);
    }

    @Override
    public List<BloqueoHorario> findByUsuarioAndFecha(Usuario usuario, LocalDate fecha) {
        return jpaRepo.findByUsuarioAndFecha(usuario, fecha);
    }

    @Override
    public List<BloqueoHorario> findByUsuarioAndActivoTrue(Usuario usuario) {
        return jpaRepo.findByUsuarioAndActivoTrue(usuario);
    }

    @Override
    public List<BloqueoHorario> findByUsuarioAndFechaAndActivoTrue(Usuario usuario, LocalDate fecha) {
        return jpaRepo.findByUsuarioAndFechaAndActivoTrue(usuario, fecha);
    }

}
