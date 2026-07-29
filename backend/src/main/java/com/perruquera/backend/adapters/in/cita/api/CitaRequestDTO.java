package com.perruquera.backend.adapters.in.cita.api;

import java.time.LocalDateTime;
import java.util.List;

public class CitaRequestDTO {

    private Long mascotaId;
    private LocalDateTime fechaHora;
    private List<Long> serviciosId;
    private String observaciones;

    public CitaRequestDTO() {
    }

    public Long getMascotaId() {
        return mascotaId;
    }

    public void setMascotaId(Long mascotaId) {
        this.mascotaId = mascotaId;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    public List<Long> getServiciosId() {
        return serviciosId;
    }

    public void setServiciosId(List<Long> serviciosId) {
        this.serviciosId = serviciosId;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
}