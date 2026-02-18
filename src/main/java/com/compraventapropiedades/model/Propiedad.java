package com.compraventapropiedades.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Propiedad")
public class Propiedad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idPropiedad")
    private int idPropiedad;

    @Column(name = "ubicacion")
    private String ubicacion;

    @Column(name = "precio")
    private int precio;

    @ManyToOne
    @JoinColumn(name = "idUsuarioDueno")
    private Usuario dueno;

    public Propiedad() {}


    // Getters y setters 

    public int getIdPropiedad() {
        return idPropiedad;
    }

    public void setIdPropiedad(int idPropiedad) {
        this.idPropiedad = idPropiedad;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public Usuario getDueno() {
        return dueno;
    }

    public void setDueno(Usuario dueno) {
        this.dueno = dueno;
    }
}