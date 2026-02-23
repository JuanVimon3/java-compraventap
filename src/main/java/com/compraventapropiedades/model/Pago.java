package com.compraventapropiedades.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Pago")
public class Pago {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idPago")
    private int idPago;

    @Column(name = "monto")
    private int monto;

    
    @Column(name = "metodoPago")
    private String metodoPago;

    @Column(name = "estadoPago")
    private String estadoPago;

    @ManyToOne
    @JoinColumn(name = "idContrato")
    private Contrato contrato;

    public Pago(){}

    // Getters y setters

    public int getIdPago(){return idPago;}
    public void setIdPago(int idPago){this.idPago = idPago;}

    public int getMonto(){return monto;}
    public void setMonto(int monto){this.monto = monto;}

    public String getMetodoPago(){return metodoPago;}
    public void setMetodoPago(String metodoPago){this.metodoPago = metodoPago;}

    public String getEstadoPago(){return estadoPago;}
    public void setEstadoPago(String estadoPago){this.estadoPago = estadoPago;}

    public Contrato getContrato(){return contrato;}
    public void setContrato(Contrato contrato){this.contrato = contrato;}

}
