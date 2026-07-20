package com.perruquera.backend.adapters.out.persistence.horario;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.perruquera.backend.entities.DiaSemana;
import com.perruquera.backend.entities.Horario;

@Repository
public class HorarioPersistence implements IHorarioPersistence {

    private final HorarioJpaPersistence jpaRepo;

    public HorarioPersistence(HorarioJpaPersistence jpaRepo) {
        this.jpaRepo = jpaRepo;
    }

    @Override
    public Horario save(Horario horario) {
        return jpaRepo.save(horario);
    }

    @Override
    public Optional<Horario> findById(Long id) {
        return jpaRepo.findById(id);
    }

    @Override
    public List<Horario> findAll() {
        return jpaRepo.findAll();
    }

    @Override
    public Optional<Horario> update(Long id, Horario horario) {
        if (!existsById(id)) {
            return Optional.empty();
        }
        horario.setId(id);
        return Optional.of(save(horario));
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
    public List<Horario> findByDiaSemana(DiaSemana diaSemana) {
        return jpaRepo.findByDiaSemana(diaSemana);
    }

}
