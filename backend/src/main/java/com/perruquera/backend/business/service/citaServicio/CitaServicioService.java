package com.perruquera.backend.business.service.citaServicio;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.perruquera.backend.adapters.out.persistence.citaServicio.ICitaServicioPersistence;
import com.perruquera.backend.business.validation.ValidationCita;
import com.perruquera.backend.business.validation.ValidationCitaServicio;
import com.perruquera.backend.business.validation.ValidationServicio;
import com.perruquera.backend.entities.Cita;
import com.perruquera.backend.entities.CitaServicio;
import com.perruquera.backend.entities.Servicio;

public class CitaServicioService implements ICitaServicioService {

    private final ICitaServicioPersistence repo;

    public CitaServicioService(ICitaServicioPersistence repo) {
        this.repo = repo;
    }

    @Override
    public CitaServicio save(CitaServicio citaServicio) {

        if (!ValidationCitaServicio.isValidCitaServicio(citaServicio)) {
            return null;
        }
        if (existsByCitaAndServicio(citaServicio.getCita(), citaServicio.getServicio())) {
            return null;

        }

        return repo.save(citaServicio);

    }

    @Override
    public Optional<CitaServicio> findById(Long id) {
        if (id == null) {
            return Optional.empty();
        }
        return repo.findById(id);

    }

    @Override
    public List<CitaServicio> findAll() {
        return repo.findAll();
    }

    @Override
    public Optional<CitaServicio> update(Long id, CitaServicio citaServicio) {
        if (id == null) {
            return Optional.empty();
        }
        if (!ValidationCitaServicio.isValidCitaServicio(citaServicio)) {
            return Optional.empty();
        }
        if (!existsById(id)) {
            return Optional.empty();
        }
        citaServicio.setId(id);
        return Optional.of(repo.save(citaServicio));
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
    public List<CitaServicio> findByCita(Cita cita) {
        if (!ValidationCita.isValidCita(cita)) {
            return new ArrayList<>();
        }
        return repo.findByCita(cita);
    }

    @Override
    public List<CitaServicio> findByServicio(Servicio servicio) {
        if (!ValidationServicio.isValidServicio(servicio)) {
            return new ArrayList<>();
        }
        return repo.findByServicio(servicio);
    }

    @Override
    public boolean existsByCitaAndServicio(Cita cita, Servicio servicio) {
        if (!ValidationCita.isValidCita(cita)) {
            return false;
        }
        if (!ValidationServicio.isValidServicio(servicio)) {
            return false;
        }
        return repo.existsByCitaAndServicio(cita, servicio);
    }

    @Override
    public Optional<CitaServicio> findByCitaAndServicio(Cita cita, Servicio servicio) {
        if (!ValidationCita.isValidCita(cita)) {
            return Optional.empty();
        }
        if (!ValidationServicio.isValidServicio(servicio)) {
            return Optional.empty();
        }
        return repo.findByCitaAndServicio(cita, servicio);
    }

}
