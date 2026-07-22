package com.perruquera.backend.adapters.in.usuario.api;

public class UsuarioResponseDTO {

    private Long id;
    private String nombre;
    private String apellidos;
    private String telefono;
    private String email;

    private String fechaRegistro;
    private boolean activo;

    public UsuarioResponseDTO() {
    }

    public UsuarioResponseDTO(Long id, String nombre, String apellidos, String telefono, String email,
            String fechaRegistro, boolean activo) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.email = email;

        this.fechaRegistro = fechaRegistro;
        this.activo = activo;
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

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(String fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

}
