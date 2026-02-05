package com.compraventapropiedades.model;

public class Usuario {

    
    private int idUsuario;
    private int cedula;
    private String email;
    private String nombre;

    
    public Usuario() {}

    
    public Usuario(int idUsuario, int cedula, String email, String nombre) {
        this.idUsuario = idUsuario;
        this.cedula = cedula;
        this.email = email;
        this.nombre = nombre;
    }

    // Getters y Setters
    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}