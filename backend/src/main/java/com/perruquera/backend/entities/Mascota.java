package com.perruquera.backend.entities;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "mascota")
public class Mascota {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;
    @ManyToOne
    @JoinColumn(name = "id_raza")
    private Raza raza;

    private String nombre;

    @Column(name = "genero")
    @Enumerated(EnumType.STRING)
    private Genero genero;

    @Column(name = "fecha_nacimiento")
    private LocalDate fechaNacimiento;
    private BigDecimal peso;

    @Column(name = "foto_url")
    private String fotoUrl;

    private String observaciones;

    public Mascota() {
    }

    public Mascota(Long id) {
        this.id = id;
    }

    public Mascota(Long id, Usuario usuario, Raza raza, String nombre, Genero genero, LocalDate fechaNacimiento,
            BigDecimal peso, String fotoUrl, String observaciones) {
        this.id = id;
        this.usuario = usuario;
        this.raza = raza;
        this.nombre = nombre;
        this.genero = genero;
        this.fechaNacimiento = fechaNacimiento;
        this.peso = peso;
        this.fotoUrl = fotoUrl;
        this.observaciones = observaciones;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Raza getRaza() {
        return raza;
    }

    public void setRaza(Raza raza) {
        this.raza = raza;
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

    @Override
    public String toString() {
        return "Mascota [id=" + id + ", usuarioId=" + (usuario != null ? usuario.getId() : null) + ", razaId="
                + (raza != null ? raza.getId() : null) + ", nombre=" + nombre + ", genero="
                + genero + ", fechaNacimiento=" + fechaNacimiento + ", peso=" + peso + ", fotoUrl=" + fotoUrl
                + ", observaciones=" + observaciones + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        if (this == obj)
            return true;
        if (!(obj instanceof Mascota)) {
            return false;
        }
        Mascota mascota = (Mascota) obj;

        return Objects.equals(id, mascota.id);

    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

}
