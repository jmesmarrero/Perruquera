package com.perruquera.backend.entities;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "cita")
public class Cita {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_mascota")
    private Mascota mascota;

    @ManyToOne
    @JoinColumn(name = "id_estado")
    private EstadoCita estado;

    @Column(name = "fecha_hora")
    private LocalDateTime fechaHora;
    @Column(name = "duracion_estimada")
    private int duracionEstimada;
    @Column(name = "precio_total")
    private BigDecimal precioTotal;
    @Column(name = "fecha_creacion")
    private LocalDateTime fechaCreacion;
    private String observaciones;

    public Cita() {
    }

    public Cita(Long id) {
        this.id = id;
    }

    public Cita(Long id, Mascota mascota, EstadoCita estado, LocalDateTime fechaHora, int duracionEstimada,
            BigDecimal precioTotal, LocalDateTime fechaCreacion, String observaciones) {
        this.id = id;
        this.mascota = mascota;
        this.estado = estado;
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

    public Mascota getMascota() {
        return mascota;
    }

    public void setMascota(Mascota mascota) {
        this.mascota = mascota;
    }

    public EstadoCita getEstado() {
        return estado;
    }

    public void setEstado(EstadoCita estado) {
        this.estado = estado;
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

    @Override
    public String toString() {
        return "Cita [id=" + id + ", mascotaId=" + (mascota != null ? mascota.getId() : null) + ", estadoId="
                + (estado != null ? estado.getId() : null) + ", fechaHora=" + fechaHora
                + ", duracionEstimada=" + duracionEstimada + ", precioTotal=" + precioTotal + ", fechaCreacion="
                + fechaCreacion + ", observaciones=" + observaciones + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        if (this == obj)
            return true;
        if (!(obj instanceof Cita)) {
            return false;
        }
        Cita cita = (Cita) obj;

        return Objects.equals(id, cita.id);

    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

}

