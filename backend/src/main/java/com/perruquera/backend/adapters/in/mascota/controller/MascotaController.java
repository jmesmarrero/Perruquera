package com.perruquera.backend.adapters.in.mascota.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.perruquera.backend.adapters.in.mascota.api.MascotaRequestDTO;
import com.perruquera.backend.adapters.in.mascota.api.MascotaResponseDTO;
import com.perruquera.backend.adapters.in.mascota.mapper.MascotaMapper;
import com.perruquera.backend.business.service.mascota.IMascotaService;
import com.perruquera.backend.entities.Mascota;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/mascotas")
@Tag(name = "Mascota API")
@CrossOrigin
public class MascotaController {

    private final IMascotaService service;
    private final MascotaMapper mapper;

    public MascotaController(IMascotaService service, MascotaMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @GetMapping
    @Operation(summary = "Get all mascotas")
    public List<MascotaResponseDTO> getAll() {
        return service.findAll()
                .stream()
                .map(mapper::toResponseDTO)
                .toList();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get mascota by id")
    public ResponseEntity<MascotaResponseDTO> getById(@PathVariable Long id) {

        return service.findById(id)
                .map(mapper::toResponseDTO)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(summary = "Create mascota")
    public ResponseEntity<MascotaResponseDTO> create(@RequestBody MascotaRequestDTO request) {

        Mascota created = service.save(mapper.toDomain(request));

        if (created == null) {
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(mapper.toResponseDTO(created));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update mascota")
    public ResponseEntity<MascotaResponseDTO> update(
            @PathVariable Long id,
            @RequestBody MascotaRequestDTO request) {

        Mascota mascota = mapper.toDomain(request);

        return service.update(id, mascota)
                .map(mapper::toResponseDTO)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PatchMapping("/{id}")
    @Operation(summary = "Update mascota (partial)")
    public ResponseEntity<MascotaResponseDTO> patch(
            @PathVariable Long id,
            @RequestBody MascotaRequestDTO request) {

        Mascota mascota = mapper.toDomain(request);

        return service.patch(id, mascota)
                .map(mapper::toResponseDTO)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete mascota")
    public ResponseEntity<Void> delete(@PathVariable Long id) {

        if (!service.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        service.deleteById(id);

        return ResponseEntity.noContent().build();
    }
}