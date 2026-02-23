package com.compraventapropiedades.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Vendedor") 
public class Vendedor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idVendedor")
    private int idVendedor;

    @OneToOne
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;

    public Vendedor() {};

    //Getters y setters de la clase Vendedor

    public int getIdVendedor(){return idVendedor; }
    public void setIdVendedor(int idVendedor){this.idVendedor = idVendedor; }

    public Usuario getUsuario(){return usuario;}
    public void setUsuario(Usuario usuario){this.usuario = usuario;}
}