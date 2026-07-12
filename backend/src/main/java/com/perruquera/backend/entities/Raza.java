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
@Table(name = "raza")
public class Raza {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_especie")
    private Especie especie;
    private String nombre;

    public Raza() {
    }

    public Raza(Long id) {
        this.id = id;
    }

    public Raza(Long id, Especie especie, String nombre) {
        this.id = id;
        this.especie = especie;
        this.nombre = nombre;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Especie getEspecie() {
        return especie;
    }

    public void setEspecie(Especie especie) {
        this.especie = especie;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Raza [id=" + id
                + ", especieId=" + (especie != null ? especie.getId() : null)
                + ", nombre=" + nombre + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        if (this == obj)
            return true;
        if (!(obj instanceof Raza)) {
            return false;
        }
        Raza raza = (Raza) obj;

        return Objects.equals(id, raza.id);

    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

}

// id INTEGER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
// id_especie INTEGER NOT NULL,
// nombre VARCHAR(50) NOT NULL,
// UNIQUE (id_especie, nombre),
// FOREIGN KEY (id_especie) REFERENCES especie(id) ON DELETE RESTRICT