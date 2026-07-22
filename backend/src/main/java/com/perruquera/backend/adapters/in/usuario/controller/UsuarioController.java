package com.perruquera.backend.adapters.in.usuario.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.perruquera.backend.adapters.in.usuario.api.UsuarioResponseDTO;
import com.perruquera.backend.adapters.in.usuario.mapper.UsuarioMapper;
import com.perruquera.backend.business.service.usuario.IUsuarioService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

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

}
