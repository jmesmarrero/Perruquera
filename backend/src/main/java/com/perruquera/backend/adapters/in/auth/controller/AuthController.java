package com.perruquera.backend.adapters.in.auth.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.perruquera.backend.adapters.in.auth.api.LoginRequestDTO;
import com.perruquera.backend.adapters.in.auth.api.LoginResponseDTO;
import com.perruquera.backend.business.service.auth.IAuthService;

import io.swagger.v3.oas.annotations.Operation;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/auth")
@Tag(name = "Auth API")
@CrossOrigin
public class AuthController {

    private final IAuthService service;

    public AuthController(IAuthService service) {
        this.service = service;
    }

    @PostMapping("/login")
    @Operation(summary = "Login de usuario")
    public ResponseEntity<String> login(@RequestBody LoginRequestDTO request) {

        return ResponseEntity.ok(service.login(request));

    }

}
