package com.perruquera.backend.adapters.in.servicio.controller;

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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.perruquera.backend.adapters.in.servicio.api.ServicioRequestDTO;
import com.perruquera.backend.adapters.in.servicio.api.ServicioResponseDTO;
import com.perruquera.backend.adapters.in.servicio.mapper.ServicioMapper;
import com.perruquera.backend.business.service.servicio.IServicioService;
import com.perruquera.backend.entities.Servicio;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/servicios")
@Tag(name = "Servicio API")
@CrossOrigin
public class ServicioController {

    private final IServicioService service;
    private final ServicioMapper mapper;

    public ServicioController(IServicioService service, ServicioMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @GetMapping
    @Operation(summary = "Get all servicios")
    public List<ServicioResponseDTO> getAll() {
        return service.findAll()
                .stream()
                .map(mapper::toResponseDTO)
                .toList();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get servicio by id")
    public ResponseEntity<ServicioResponseDTO> getById(@PathVariable Long id) {
        return service.findById(id)
                .map(mapper::toResponseDTO)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(summary = "Create servicio")
    public ResponseEntity<ServicioResponseDTO> create(@RequestBody ServicioRequestDTO request) {

        Servicio created = service.save(mapper.toDomain(request));

        if (created == null) {
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(mapper.toResponseDTO(created));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update servicio")
    public ResponseEntity<ServicioResponseDTO> update(
            @PathVariable Long id,
            @RequestBody ServicioRequestDTO request) {

        Servicio servicio = mapper.toDomain(request);

        return service.update(id, servicio)
                .map(mapper::toResponseDTO)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PatchMapping("/{id}")
    @Operation(summary = "Update servicio (partial)")
    public ResponseEntity<ServicioResponseDTO> patch(
            @PathVariable Long id,
            @RequestBody ServicioRequestDTO request) {

        Servicio servicio = mapper.toDomain(request);

        return service.patch(id, servicio)
                .map(mapper::toResponseDTO)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete servicio")
    public ResponseEntity<Void> delete(@PathVariable Long id) {

        if (!service.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
