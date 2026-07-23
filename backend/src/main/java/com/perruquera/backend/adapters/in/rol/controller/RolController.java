package com.perruquera.backend.adapters.in.rol.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.perruquera.backend.adapters.in.rol.api.RolRequestDTO;
import com.perruquera.backend.adapters.in.rol.api.RolResponseDTO;
import com.perruquera.backend.adapters.in.rol.mapper.RolMapper;
import com.perruquera.backend.business.service.rol.IRolService;
import com.perruquera.backend.entities.Rol;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("api/roles")
@Tag(name = "Rol API")
@CrossOrigin
public class RolController {
    private final IRolService service;
    private final RolMapper mapper;

    public RolController(IRolService service, RolMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @GetMapping
    @Operation(summary = "Get all roles")
    public List<RolResponseDTO> getAll() {
        return service.findAll().stream().map(mapper::toResponseDTO).toList();

    }

    @GetMapping("/{id}")
    @Operation(summary = "Get rol by id")
    public ResponseEntity<RolResponseDTO> getById(@PathVariable Long id) {
        return service.findById(id).map(mapper::toResponseDTO).map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(summary = "create rol")
    public ResponseEntity<RolResponseDTO> create(@RequestBody RolRequestDTO request) {
        Rol created = service.save(mapper.toDomain(request));

        if (created == null) {
            return ResponseEntity.badRequest().build();

        }
        return ResponseEntity.status(HttpStatus.CREATED).body(mapper.toResponseDTO(created));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update rol")
    public ResponseEntity<RolResponseDTO> update(@PathVariable Long id, @RequestBody RolRequestDTO request) {

        Rol rol = mapper.toDomain(request);

        return service.update(id, rol).map(mapper::toResponseDTO).map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PatchMapping("/{id}")
    @Operation(summary = "Update rol(partial)")
    public ResponseEntity<RolResponseDTO> patch(@PathVariable Long id, @RequestBody RolRequestDTO request) {

        Rol rol = mapper.toDomain(request);

        return service.patch(id, rol).map(mapper::toResponseDTO).map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete rol")
    public ResponseEntity<Void> delete(@PathVariable Long id) {

        if (!service.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
