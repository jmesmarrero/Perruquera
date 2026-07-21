package com.perruquera.backend.business.service.bloqueoHorario;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.perruquera.backend.adapters.out.persistence.bloqueoHorario.IBloqueoHorarioPersistence;
import com.perruquera.backend.business.validation.ValidationBloqueoHorario;
import com.perruquera.backend.business.validation.ValidationUsuario;
import com.perruquera.backend.business.validation.ValidationUtils;
import com.perruquera.backend.entities.BloqueoHorario;
import com.perruquera.backend.entities.Usuario;

public class BloqueoHorarioService implements IBloqueoHorarioService {

    private final IBloqueoHorarioPersistence repo;

    public BloqueoHorarioService(IBloqueoHorarioPersistence repo) {
        this.repo = repo;
    }

    @Override
    public BloqueoHorario save(BloqueoHorario bloqueoHorario) {
        if (!ValidationBloqueoHorario.isValidBloqueoHorario(bloqueoHorario)) {
            return null;
        }
        return repo.save(bloqueoHorario);
    }

    @Override
    public Optional<BloqueoHorario> findById(Long id) {
        if (id == null) {
            return Optional.empty();

        }

        return repo.findById(id);
    }

    @Override
    public List<BloqueoHorario> findAll() {
        return repo.findAll();
    }

    @Override
    public Optional<BloqueoHorario> update(Long id, BloqueoHorario bloqueoHorario) {
        if (id == null) {
            return Optional.empty();
        }
        if (!ValidationBloqueoHorario.isValidBloqueoHorario(bloqueoHorario)) {
            return Optional.empty();
        }
        if (!existsById(id)) {
            return Optional.empty();
        }
        bloqueoHorario.setId(id);
        return Optional.of(repo.save(bloqueoHorario));
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
    public List<BloqueoHorario> findByUsuario(Usuario usuario) {
        if (!ValidationUsuario.isValidUsuario(usuario)) {
            return new ArrayList<>();
        }
        return repo.findByUsuario(usuario);
    }

    @Override
    public List<BloqueoHorario> findByFecha(LocalDate fecha) {
        if (!ValidationUtils.isValidFecha(fecha)) {
            return new ArrayList<>();
        }
        return repo.findByFecha(fecha);
    }

    @Override
    public List<BloqueoHorario> findByUsuarioAndFecha(Usuario usuario, LocalDate fecha) {
        if (!ValidationUsuario.isValidUsuario(usuario)) {
            return new ArrayList<>();
        }
        if (!ValidationUtils.isValidFecha(fecha)) {
            return new ArrayList<>();
        }
        return repo.findByUsuarioAndFecha(usuario, fecha);
    }

    @Override
    public List<BloqueoHorario> findByUsuarioAndActivoTrue(Usuario usuario) {
        if (!ValidationUsuario.isValidUsuario(usuario)) {
            return new ArrayList<>();
        }
        return repo.findByUsuarioAndActivoTrue(usuario);
    }

    @Override
    public List<BloqueoHorario> findByUsuarioAndFechaAndActivoTrue(Usuario usuario, LocalDate fecha) {
        if (!ValidationUsuario.isValidUsuario(usuario)) {
            return new ArrayList<>();
        }
        if (!ValidationUtils.isValidFecha(fecha)) {
            return new ArrayList<>();
        }
        return repo.findByUsuarioAndFechaAndActivoTrue(usuario, fecha);
    }

}
