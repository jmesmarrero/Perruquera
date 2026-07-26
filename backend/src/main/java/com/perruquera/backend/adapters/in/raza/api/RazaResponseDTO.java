package com.perruquera.backend.adapters.in.raza.api;

public class RazaResponseDTO {

    private Long id;
    private Long especieId;
    private String especieNombre;
    private String nombre;

    public RazaResponseDTO() {
    }

    public RazaResponseDTO(Long id, Long especieId, String especieNombre, String nombre) {
        this.id = id;
        this.especieId = especieId;
        this.especieNombre = especieNombre;
        this.nombre = nombre;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getEspecieId() {
        return especieId;
    }

    public void setEspecieId(Long especieId) {
        this.especieId = especieId;
    }

    public String getEspecieNombre() {
        return especieNombre;
    }

    public void setEspecieNombre(String especieNombre) {
        this.especieNombre = especieNombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
