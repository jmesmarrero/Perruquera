package com.perruquera.backend.adapters.in.bloqueoHorario.controller;

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

import com.perruquera.backend.adapters.in.bloqueoHorario.api.BloqueoHorarioRequestDTO;
import com.perruquera.backend.adapters.in.bloqueoHorario.api.BloqueoHorarioResponseDTO;
import com.perruquera.backend.adapters.in.bloqueoHorario.mapper.BloqueoHorarioMapper;
import com.perruquera.backend.business.service.bloqueoHorario.IBloqueoHorarioService;
import com.perruquera.backend.entities.BloqueoHorario;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/bloqueoHorarios")
@Tag(name = "BloqueoHorarios API")
@CrossOrigin
public class BloqueoHorarioController {

    private final IBloqueoHorarioService service;
    private final BloqueoHorarioMapper mapper;

    public BloqueoHorarioController(IBloqueoHorarioService service, BloqueoHorarioMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @GetMapping
    @Operation(summary = " Get all bloqueoHorarios")
    public List<BloqueoHorarioResponseDTO> getAll() {
        return service.findAll().stream().map(mapper::toResponse).toList();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get bloqueoHorario by id")
    public ResponseEntity<BloqueoHorarioResponseDTO> getById(@PathVariable Long id) {
        return service.findById(id).map(mapper::toResponse).map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(summary = "Create BloqueoHorario")
    public ResponseEntity<BloqueoHorarioResponseDTO> create(@RequestBody BloqueoHorarioRequestDTO request) {

        BloqueoHorario created = service.save(mapper.toDomain(request));

        if (created == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(mapper.toResponse(created));
    }

    @PutMapping("{id}")
    @Operation(summary = "Update bloqueoHorarios")
    public ResponseEntity<BloqueoHorarioResponseDTO> update(@PathVariable Long id,
            @RequestBody BloqueoHorarioRequestDTO request) {

        BloqueoHorario bloqueoHorario = mapper.toDomain(request);

        return service.update(id, bloqueoHorario).map(mapper::toResponse).map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PatchMapping("/{id}")
    @Operation(summary = "Update bloqueoHorarios (partial)")
    public ResponseEntity<BloqueoHorarioResponseDTO> patch(@PathVariable Long id,
            @RequestBody BloqueoHorarioRequestDTO request) {

        BloqueoHorario bloqueoHorario = mapper.toDomain(request);

        return service.patch(id, bloqueoHorario).map(mapper::toResponse).map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete bloqueoHorario")
    public ResponseEntity<Void> delete(@PathVariable Long id) {

        if (!service.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
