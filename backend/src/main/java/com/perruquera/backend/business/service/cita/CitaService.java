package com.perruquera.backend.business.service.cita;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.perruquera.backend.adapters.out.persistence.cita.ICitaPersistence;
import com.perruquera.backend.business.validation.ValidationCita;
import com.perruquera.backend.business.validation.ValidationEstadoCita;
import com.perruquera.backend.business.validation.ValidationMascota;
import com.perruquera.backend.business.validation.ValidationUtils;
import com.perruquera.backend.entities.Cita;
import com.perruquera.backend.entities.EstadoCita;
import com.perruquera.backend.entities.Mascota;

@Service
public class CitaService implements ICitaService {

    private ICitaPersistence repo;

    public CitaService(ICitaPersistence repo) {
        this.repo = repo;
    }

    @Override
    public Cita save(Cita cita) {
        if (!ValidationCita.isValidCita(cita)) {
            return null;
        }
        return repo.save(cita);
    }

    @Override
    public Optional<Cita> findById(Long id) {
        if (id == null) {
            return Optional.empty();
        }
        return repo.findById(id);
    }

    @Override
    public List<Cita> findAll() {
        return repo.findAll();
    }

    @Override
    public Optional<Cita> update(Long id, Cita cita) {
        if (id == null) {
            return Optional.empty();
        }
        if (!ValidationCita.isValidCita(cita)) {
            return Optional.empty();
        }
        if (!existsById(id)) {
            return Optional.empty();
        }
        cita.setId(id);
        return Optional.of(repo.save(cita));
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
    public List<Cita> findByMascota(Mascota mascota) {
        if (!ValidationMascota.isValidMascota(mascota)) {
            return new ArrayList<>();
        }
        return repo.findByMascota(mascota);
    }

    @Override
    public List<Cita> findByEstado(EstadoCita estado) {
        if (!ValidationEstadoCita.isValidEstadoCita(estado)) {
            return new ArrayList<>();
        }
        return repo.findByEstado(estado);

    }

    @Override
    public List<Cita> findByFechaHoraBetween(LocalDateTime inicio, LocalDateTime fin) {
        if (!ValidationUtils.isValidFechaHora(inicio) || !ValidationUtils.isValidFechaHora(fin)) {
            return new ArrayList<>();
        }
        if (inicio.isAfter(fin)) {
            return new ArrayList<>();
        }
        return repo.findByFechaHoraBetween(inicio, fin);
    }

    @Override
    public List<Cita> findByMascotaOrderByFechaHoraDesc(Mascota mascota) {
        if (!ValidationMascota.isValidMascota(mascota)) {
            return new ArrayList<>();
        }
        return repo.findByMascotaOrderByFechaHoraDesc(mascota);
    }

    @Override
    public List<Cita> findByEstadoOrderByFechaHoraAsc(EstadoCita estado) {
        if (!ValidationEstadoCita.isValidEstadoCita(estado)) {
            return new ArrayList<>();
        }
        return repo.findByEstadoOrderByFechaHoraAsc(estado);
    }

}
