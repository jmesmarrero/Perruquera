package com.perruquera.backend.adapters.in.usuario.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.perruquera.backend.adapters.in.usuario.api.UsuarioRequestDTO;
import com.perruquera.backend.adapters.in.usuario.api.UsuarioResponseDTO;
import com.perruquera.backend.adapters.in.usuario.mapper.UsuarioMapper;
import com.perruquera.backend.business.service.usuario.IUsuarioService;
import com.perruquera.backend.entities.Usuario;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/usuarios")
@Tag(name = "Usuarios API")
@CrossOrigin
public class UsuarioController {

    private final IUsuarioService service;
    private final UsuarioMapper mapper;

    public UsuarioController(IUsuarioService service, UsuarioMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @GetMapping
    @Operation(summary = "Get all usuarios")
    public List<UsuarioResponseDTO> getAll() {
        return service.findAll().stream().map(mapper::toResponseDTO).toList();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get usuario by id")
    public ResponseEntity<UsuarioResponseDTO> getById(@PathVariable Long id) {
        return service.findById(id).map(mapper::toResponseDTO).map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(summary = "Create usuario")
    public ResponseEntity<UsuarioResponseDTO> create(@RequestBody UsuarioRequestDTO requestDTO) {

        Usuario created = service.save(mapper.toDomain(requestDTO));
        if (created == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(mapper.toResponseDTO(created));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update usuario")
    public ResponseEntity<UsuarioResponseDTO> update(@PathVariable Long id, @RequestBody UsuarioRequestDTO request) {

        Usuario usuario = mapper.toDomain(request);

        return service.update(id, usuario)
                .map(mapper::toResponseDTO)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());

    }

    @PatchMapping("/{id}")
    @Operation(summary = "Update usuario (partial)")
    public ResponseEntity<UsuarioResponseDTO> patch(
            @PathVariable Long id,
            @RequestBody UsuarioRequestDTO request) {

        Usuario usuario = mapper.toDomain(request);

        return service.patch(id, usuario)
                .map(mapper::toResponseDTO)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete usuario")
    public ResponseEntity<Void> delete(@PathVariable Long id) {

        if (!service.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
