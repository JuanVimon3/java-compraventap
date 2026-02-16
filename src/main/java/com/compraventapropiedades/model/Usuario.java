package com.compraventapropiedades.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUsuario;
    private int cedula;
    private String email;
    private String nombre;
    private String contraseña; // Nuevo atributo
    

    public Usuario() {}

  
    public Usuario(int idUsuario, int cedula, String email, String nombre, String contraseña) {
        this.idUsuario = idUsuario;
        this.cedula = cedula;
        this.email = email;
        this.nombre = nombre;
        this.contraseña = contraseña;
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


    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
}