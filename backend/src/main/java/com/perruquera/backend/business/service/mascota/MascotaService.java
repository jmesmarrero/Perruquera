package com.perruquera.backend.business.service.mascota;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.perruquera.backend.adapters.out.persistence.mascota.IMascotaPersistence;
import com.perruquera.backend.business.validation.ValidationMascota;
import com.perruquera.backend.business.validation.ValidationUsuario;
import com.perruquera.backend.business.validation.ValidationUtils;
import com.perruquera.backend.entities.Mascota;
import com.perruquera.backend.entities.Usuario;

@Service
public class MascotaService implements IMascotaService {

    private final IMascotaPersistence repo;

    public MascotaService(IMascotaPersistence repo) {
        this.repo = repo;
    }

    @Override
    public Mascota save(Mascota mascota) {
        if (!ValidationMascota.isValidMascota(mascota)) {
            return null;
        }
        if (repo.findByUsuarioAndNombre(mascota.getUsuario(), mascota.getNombre()).isPresent()) {
            return null;
        }
        return repo.save(mascota);
    }

    @Override
    public Optional<Mascota> findById(Long id) {
        if (id == null) {
            return Optional.empty();
        }
        return repo.findById(id);
    }

    @Override
    public List<Mascota> findAll() {
        return repo.findAll();
    }

    @Override
    public Optional<Mascota> update(Long id, Mascota mascota) {
        if (id == null) {
            return Optional.empty();
        }
        if (!ValidationMascota.isValidMascota(mascota)) {
            return Optional.empty();
        }
        if (!existsById(id)) {
            return Optional.empty();
        }

        mascota.setId(id);

        return Optional.of(repo.save(mascota));
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
    public List<Mascota> findByNombre(String nombre) {
        if (!ValidationUtils.isValidNombre(nombre)) {
            return new ArrayList<>();
        }
        return repo.findByNombre(nombre);
    }

    @Override
    public List<Mascota> findByUsuario(Usuario usuario) {
        if (!ValidationUsuario.isValidUsuario(usuario)) {
            return new ArrayList<>();
        }
        return repo.findByUsuario(usuario);
    }

    @Override
    public Optional<Mascota> findByUsuarioAndNombre(Usuario usuario, String nombre) {
        if (!ValidationUsuario.isValidUsuario(usuario)) {
            return Optional.empty();
        }
        if (!ValidationUtils.isValidNombre(nombre)) {
            return Optional.empty();
        }
        return repo.findByUsuarioAndNombre(usuario, nombre);
    }

}
