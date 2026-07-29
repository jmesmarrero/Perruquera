package com.perruquera.backend.adapters.in.cita.api;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class CitaResponseDTO {

    private Long id;

    private Long mascotaId;
    private String mascotaNombre;

    private Long estadoId;
    private String estadoNombre;

    private LocalDateTime fechaHora;
    private int duracionEstimada;
    private BigDecimal precioTotal;
    private LocalDateTime fechaCreacion;
    private String observaciones;

    public CitaResponseDTO() {
    }

    public CitaResponseDTO(Long id, Long mascotaId, String mascotaNombre,
            Long estadoId, String estadoNombre,
            LocalDateTime fechaHora, int duracionEstimada,
            BigDecimal precioTotal, LocalDateTime fechaCreacion,
            String observaciones) {

        this.id = id;
        this.mascotaId = mascotaId;
        this.mascotaNombre = mascotaNombre;
        this.estadoId = estadoId;
        this.estadoNombre = estadoNombre;
        this.fechaHora = fechaHora;
        this.duracionEstimada = duracionEstimada;
        this.precioTotal = precioTotal;
        this.fechaCreacion = fechaCreacion;
        this.observaciones = observaciones;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMascotaId() {
        return mascotaId;
    }

    public void setMascotaId(Long mascotaId) {
        this.mascotaId = mascotaId;
    }

    public String getMascotaNombre() {
        return mascotaNombre;
    }

    public void setMascotaNombre(String mascotaNombre) {
        this.mascotaNombre = mascotaNombre;
    }

    public Long getEstadoId() {
        return estadoId;
    }

    public void setEstadoId(Long estadoId) {
        this.estadoId = estadoId;
    }

    public String getEstadoNombre() {
        return estadoNombre;
    }

    public void setEstadoNombre(String estadoNombre) {
        this.estadoNombre = estadoNombre;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    public int getDuracionEstimada() {
        return duracionEstimada;
    }

    public void setDuracionEstimada(int duracionEstimada) {
        this.duracionEstimada = duracionEstimada;
    }

    public BigDecimal getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(BigDecimal precioTotal) {
        this.precioTotal = precioTotal;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

}