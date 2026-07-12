package com.perruquera.backend.entities;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "cita_servicio")
public class CitaServicio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_cita")
    private Cita cita;

    @ManyToOne
    @JoinColumn(name = "id_servicio")
    private Servicio servicio;

    public CitaServicio() {
    }

    public CitaServicio(Long id) {
        this.id = id;
    }

    public CitaServicio(Long id, Cita cita, Servicio servicio) {
        this.id = id;
        this.cita = cita;
        this.servicio = servicio;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cita getCita() {
        return cita;
    }

    public void setCita(Cita cita) {
        this.cita = cita;
    }

    public Servicio getServicio() {
        return servicio;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }

    @Override
    public String toString() {
        return "CitaServicio [id=" + id + ", citaId=" + (cita != null ? cita.getId() : null) + ", servicioId="
                + (servicio != null ? servicio.getId() : null) + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        if (this == obj)
            return true;
        if (!(obj instanceof CitaServicio)) {
            return false;
        }
        CitaServicio citaServicio = (CitaServicio) obj;

        return Objects.equals(id, citaServicio.id);

    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

}
