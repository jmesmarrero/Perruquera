package com.perruquera.backend.adapters.in.raza.api;



public class RazaRequestDTO {


    private Long especieId;
    private String nombre;

    public RazaRequestDTO() {
    }

    public Long getEspecieId() {
        return especieId;
    }

    public void setEspecieId(Long especieId) {
        this.especieId = especieId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    
}
