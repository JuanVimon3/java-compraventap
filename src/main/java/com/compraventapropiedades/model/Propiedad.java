package com.compraventapropiedades.model;

public class Propiedad {

    private int idPropiedad;
    private String ubicacion;
    private int precio;
    private Integer idUsuarioDueno;

    public Propiedad() {}

    public Propiedad(int idPropiedad, String ubicacion, int precio, Integer idUsuarioDueno) {
        this.idPropiedad = idPropiedad;
        this.ubicacion = ubicacion;
        this.precio = precio;
        this.idUsuarioDueno = idUsuarioDueno;
    }

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

    public int getIdUsuarioDueno() {
        return idUsuarioDueno;
    }

    public void setIdUsuarioDueno(Integer idUsuarioDueno) {
        this.idUsuarioDueno = idUsuarioDueno;
    }
}