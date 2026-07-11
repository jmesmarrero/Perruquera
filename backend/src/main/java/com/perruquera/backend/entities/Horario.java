package com.perruquera.backend.entities;

import java.time.LocalTime;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "horario")
public class Horario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "dia_semana")
    @Enumerated(EnumType.STRING)
    private DiaSemana diaSemana;
    @Column(name = "hora_apertura")
    private LocalTime horaApertura;
    @Column(name = "hora_cierre")
    private LocalTime horaCierre;
    private boolean activo;

    public Horario() {
    }

    public Horario(Long id) {
        this.id = id;
    }

    public Horario(Long id, DiaSemana diaSemana, LocalTime horaApertura, LocalTime horaCierre, boolean activo) {
        this.id = id;
        this.diaSemana = diaSemana;
        this.horaApertura = horaApertura;
        this.horaCierre = horaCierre;
        this.activo = activo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public DiaSemana getDiaSemana() {
        return diaSemana;
    }

    public void setDiaSemana(DiaSemana diaSemana) {
        this.diaSemana = diaSemana;
    }

    public LocalTime getHoraApertura() {
        return horaApertura;
    }

    public void setHoraApertura(LocalTime horaApertura) {
        this.horaApertura = horaApertura;
    }

    public LocalTime getHoraCierre() {
        return horaCierre;
    }

    public void setHoraCierre(LocalTime horaCierre) {
        this.horaCierre = horaCierre;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    @Override
    public String toString() {
        return "Horario [id=" + id + ", diaSemana=" + diaSemana + ", horaApertura=" + horaApertura + ", horaCierre="
                + horaCierre + ", activo=" + activo + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        if (this == obj)
            return true;
        if (!(obj instanceof Horario)) {
            return false;
        }
        Horario horario = (Horario) obj;

        return Objects.equals(id, horario.id);

    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

}
