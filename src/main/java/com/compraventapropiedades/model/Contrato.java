package com.compraventapropiedades.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Contrato")
public class Contrato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idContrato")
    private int idContrato;

    //Definición de fechas de inicio y fin para cada contrato
    @Column(name = "fechaInicio")
    @Temporal(TemporalType.DATE)
    private Date fechaInicio;

    @Column(name = "fechaFin")
    @Temporal(TemporalType.DATE)
    private Date fechaFin;

    @Column(name = "condiciones")
    private String condiciones;

    @ManyToOne
    @JoinColumn(name = "idVendedor") //FK idVendedor
    private Vendedor vendedor;

    @ManyToOne
    @JoinColumn(name = "idPropiedad")// Fk idPropiedad
    private Propiedad propiedad;

    public Contrato (){}

    //Getters y setters para contrato

    public int getIdContrato(){return idContrato;}
    public void setIdContrato(int idContrato){this.idContrato = idContrato;}

    public Date getFechaInicio(){return fechaInicio;}
    public void setFechaInicio(Date fechaInicio){this.fechaInicio = fechaInicio;}

    public Date getFechaFin(){return fechaFin;}
    public void setFechaFin(Date fechaFin){this.fechaFin = fechaFin;}

    public String getCondiciones(){return condiciones;}
    public void setCondiciones(String condiciones){this.condiciones = condiciones;}

    public Vendedor getVendedor(){return vendedor;}
    public void setVendedor(Vendedor vendedor){this.vendedor = vendedor;}

    public Propiedad getPropiedad(){return propiedad;}
    public void setPropiedad(Propiedad propiedad){this.propiedad = propiedad;}
    
}
