package com.perruquera.backend.adapters.in.raza.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.perruquera.backend.adapters.in.raza.api.RazaRequestDTO;
import com.perruquera.backend.adapters.in.raza.api.RazaResponseDTO;
import com.perruquera.backend.adapters.in.raza.mapper.RazaMapper;
import com.perruquera.backend.business.service.raza.IRazaService;
import com.perruquera.backend.entities.Raza;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/razas")
@Tag(name = "Raza API")
@CrossOrigin
public class RazaController {

    private final IRazaService service;
    private final RazaMapper mapper;

    public RazaController(IRazaService service, RazaMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @GetMapping
    @Operation(summary = "Get all razas")
    public List<RazaResponseDTO> getAll() {
        return service.findAll()
                .stream()
                .map(mapper::toResponse)
                .toList();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get raza by id")
    public ResponseEntity<RazaResponseDTO> getById(@PathVariable Long id) {

        return service.findById(id)
                .map(mapper::toResponse)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(summary = "Create raza")
    public ResponseEntity<RazaResponseDTO> create(@RequestBody RazaRequestDTO request) {

        Raza created = service.save(mapper.toDomain(request));

        if (created == null) {
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(mapper.toResponse(created));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update raza")
    public ResponseEntity<RazaResponseDTO> update(
            @PathVariable Long id,
            @RequestBody RazaRequestDTO request) {

        Raza raza = mapper.toDomain(request);

        return service.update(id, raza)
                .map(mapper::toResponse)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PatchMapping("/{id}")
    @Operation(summary = "Update raza (partial)")
    public ResponseEntity<RazaResponseDTO> patch(
            @PathVariable Long id,
            @RequestBody RazaRequestDTO request) {

        Raza raza = mapper.toDomain(request);

        return service.patch(id, raza)
                .map(mapper::toResponse)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete raza")
    public ResponseEntity<Void> delete(@PathVariable Long id) {

        if (!service.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}