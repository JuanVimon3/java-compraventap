package com.compraventapropiedades.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Administrador")
public class Administrador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idAdministrador")
    private int idAdministrador;

    @OneToOne
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;

    public Administrador(){}

    // Getters y setters

    public int getIdAdministrador(){return idAdministrador;}
    public void  setIdAdministrador(int idAdministrador){this.idAdministrador = idAdministrador;}

    public Usuario getUsuario(){return usuario;}
    public void setUsuario(Usuario usuario){this.usuario = usuario;}
    
}
