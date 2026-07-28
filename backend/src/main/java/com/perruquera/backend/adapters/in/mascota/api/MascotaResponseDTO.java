package com.perruquera.backend.adapters.in.mascota.api;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.perruquera.backend.entities.Genero;

public class MascotaResponseDTO {

    private Long id;
    private Long usuarioId;
    private Long razaId;
    private String nombre;
    private Genero genero;
    private LocalDate fechaNacimiento;
    private BigDecimal peso;
    private String fotoUrl;
    private String observaciones;
    private boolean activo;

    public MascotaResponseDTO() {
    }

    public MascotaResponseDTO(Long id, Long usuarioId, Long razaId, String nombre, Genero genero,
            LocalDate fechaNacimiento, BigDecimal peso, String fotoUrl, String observaciones, boolean activo) {
        this.id = id;
        this.usuarioId = usuarioId;
        this.razaId = razaId;
        this.nombre = nombre;
        this.genero = genero;
        this.fechaNacimiento = fechaNacimiento;
        this.peso = peso;
        this.fotoUrl = fotoUrl;
        this.observaciones = observaciones;
        this.activo = activo;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public Long getRazaId() {
        return razaId;
    }

    public void setRazaId(Long razaId) {
        this.razaId = razaId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public BigDecimal getPeso() {
        return peso;
    }

    public void setPeso(BigDecimal peso) {
        this.peso = peso;
    }

    public String getFotoUrl() {
        return fotoUrl;
    }

    public void setFotoUrl(String fotoUrl) {
        this.fotoUrl = fotoUrl;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public boolean getActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

}
