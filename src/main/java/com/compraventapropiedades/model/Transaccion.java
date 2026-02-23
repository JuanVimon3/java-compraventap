package com.compraventapropiedades.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Transaccion")
public class Transaccion {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idTransaccion")
    private int idTransaccion;

    @Temporal(TemporalType.DATE)
    @Column(name =  "fechaCompra")
    private Date fechaCompra; 

    @Column(name =  "valorTotal")
    private int valorTotal;

    @ManyToOne
    @JoinColumn(name = "idUsuario") // FK a usuario comprador
    private Usuario usuario;

    public Transaccion(){};

    //Getters y setters

    public int getIdTransaccion(){return idTransaccion;}
    public void setIdTransaccion(int idTransaccion){this.idTransaccion = idTransaccion;}

    public Date getFechaCompra(){return fechaCompra;}
    public void setFechaCompra(Date fechaCompra){this.fechaCompra = fechaCompra;}

    public int getValorTotal(){return valorTotal;}
    public void setValorTotal(int valorTotal){this.valorTotal = valorTotal;}

    public Usuario getUsuario(){return usuario;}
    public void setUsuario(Usuario usuario){this.usuario = usuario;}
}
