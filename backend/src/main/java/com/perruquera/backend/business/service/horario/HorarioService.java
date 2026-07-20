package com.perruquera.backend.business.service.horario;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.perruquera.backend.adapters.out.persistence.horario.IHorarioPersistence;
import com.perruquera.backend.business.validation.ValidationHorario;
import com.perruquera.backend.business.validation.ValidationUtils;
import com.perruquera.backend.entities.DiaSemana;
import com.perruquera.backend.entities.Horario;



public class HorarioService implements IHorarioService {

    private final IHorarioPersistence repo;

    public HorarioService(IHorarioPersistence repo) {
        this.repo = repo;
    }

    @Override
    public Horario save(Horario horario) {
        if (!ValidationHorario.isValidHorario(horario)) {
            return null;
        }
        return repo.save(horario);
    }

    @Override
    public Optional<Horario> findById(Long id) {
        if (id == null) {
            return Optional.empty();
        }
        return repo.findById(id);
    }

    @Override
    public List<Horario> findAll() {
        return repo.findAll();
    }

    @Override
    public Optional<Horario> update(Long id, Horario horario) {
        if (id == null) {
            return Optional.empty();
        }
        if (!ValidationHorario.isValidHorario(horario)) {
            return Optional.empty();
        }
        if (!existsById(id)) {
            return Optional.empty();
        }
        horario.setId(id);
        return Optional.of(repo.save(horario));
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
    public List<Horario> findByDiaSemana(DiaSemana diaSemana) {
        if (!ValidationUtils.isValidDiaSemana(diaSemana)) {
            return new ArrayList<>();
        }
        return repo.findByDiaSemana(diaSemana);
    }

}
