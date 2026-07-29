package com.perruquera.backend.adapters.in.cita.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.perruquera.backend.adapters.in.cita.api.CitaRequestDTO;
import com.perruquera.backend.adapters.in.cita.api.CitaResponseDTO;
import com.perruquera.backend.adapters.in.cita.mapper.CitaMapper;
import com.perruquera.backend.business.service.cita.ICitaService;
import com.perruquera.backend.entities.Cita;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/citas")
@Tag(name = "Citas API")
@CrossOrigin
public class CitaController {

    private final ICitaService service;
    private final CitaMapper mapper;

    public CitaController(ICitaService service, CitaMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @GetMapping
    @Operation(summary = "Get all citas")
    public List<CitaResponseDTO> getAll() {
        return service.findAll().stream()
                .map(mapper::toResponseDTO)
                .toList();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get cita by id")
    public ResponseEntity<CitaResponseDTO> getById(@PathVariable Long id) {

        return service.findById(id)
                .map(mapper::toResponseDTO)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(summary = "Create cita")
    public ResponseEntity<CitaResponseDTO> create(@RequestBody CitaRequestDTO request) {

        Cita created = service.save(mapper.toDomain(request));

        if (created == null) {
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(mapper.toResponseDTO(created));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update cita")
    public ResponseEntity<CitaResponseDTO> update(
            @PathVariable Long id,
            @RequestBody CitaRequestDTO request) {

        Cita cita = mapper.toDomain(request);

        return service.update(id, cita)
                .map(mapper::toResponseDTO)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PatchMapping("/{id}")
    @Operation(summary = "Update cita (partial)")
    public ResponseEntity<CitaResponseDTO> patch(
            @PathVariable Long id,
            @RequestBody CitaRequestDTO request) {

        Cita cita = mapper.toDomain(request);

        return service.patch(id, cita)
                .map(mapper::toResponseDTO)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete cita")
    public ResponseEntity<Void> delete(@PathVariable Long id) {

        if (!service.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}