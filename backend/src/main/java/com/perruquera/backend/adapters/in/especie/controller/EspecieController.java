package com.perruquera.backend.adapters.in.especie.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.perruquera.backend.adapters.in.especie.api.EspecieRequestDTO;
import com.perruquera.backend.adapters.in.especie.api.EspecieResponseDTO;
import com.perruquera.backend.adapters.in.especie.mapper.EspecieMapper;
import com.perruquera.backend.business.service.especie.IEspecieService;
import com.perruquera.backend.entities.Especie;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/api/especies")
@Tag(name = "Rol API")
@CrossOrigin
public class EspecieController {

    private final IEspecieService service;
    private final EspecieMapper mapper;

    public EspecieController(IEspecieService service, EspecieMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @GetMapping
    @Operation(summary = "Get all especies")
    public List<EspecieResponseDTO> getAll() {
        return service.findAll().stream().map(mapper::toResponse).toList();

    }

    @GetMapping("/{id}")
    @Operation(summary = "Get especie by id")
    public ResponseEntity<EspecieResponseDTO> getById(@PathVariable Long id) {
        return service.findById(id).map(mapper::toResponse).map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(summary = "create especie")
    public ResponseEntity<EspecieResponseDTO> create(@RequestBody EspecieRequestDTO request) {

        Especie created = service.save(mapper.toDomain(request));

        if (created == null) {
            return ResponseEntity.badRequest().build();

        }
        return ResponseEntity.status(HttpStatus.CREATED).body(mapper.toResponse(created));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update especie")
    public ResponseEntity<EspecieResponseDTO> update(@PathVariable Long id, @RequestBody EspecieRequestDTO request) {

        Especie especie = mapper.toDomain(request);

        return service.update(id, especie).map(mapper::toResponse).map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PatchMapping("/{id}")
    @Operation(summary = "Update especie(Partial)")
    public ResponseEntity<EspecieResponseDTO> patch(@PathVariable Long id, @RequestBody EspecieRequestDTO request) {

        Especie especie = mapper.toDomain(request);

        return service.patch(id, especie).map(mapper::toResponse).map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete by id")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (!service.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
