package com.perruquera.backend.entities;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "estado_cita")
public class EstadoCita {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nombre")
    private String nombre;

    public EstadoCita() {
    }

    public EstadoCita(Long id) {
        this.id = id;
    }

    public EstadoCita(Long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "EstadoCita [id=" + id + ", nombre=" + nombre + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        if (this == obj)
            return true;
        if (!(obj instanceof EstadoCita)) {
            return false;
        }
        EstadoCita estadoCita = (EstadoCita) obj;

        return Objects.equals(id, estadoCita.id);

    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

}
