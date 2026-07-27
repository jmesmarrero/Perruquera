package com.perruquera.backend.adapters.in.servicio.api;

import java.math.BigDecimal;

public class ServicioRequestDTO {

    private String nombre;
    private String descripcion;
    private BigDecimal precio;
    private int duracionEstimada;

    public ServicioRequestDTO (){}

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public int getDuracionEstimada() {
        return duracionEstimada;
    }

    public void setDuracionEstimada(int duracionEstimada) {
        this.duracionEstimada = duracionEstimada;
    }

    


}

