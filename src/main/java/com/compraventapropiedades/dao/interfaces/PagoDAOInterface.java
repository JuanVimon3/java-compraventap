package com.compraventapropiedades.dao.interfaces;

import com.compraventapropiedades.model.Pago;
import java.util.List;


public interface PagoDAOInterface {
    //CRUD
    void registrarPago(Pago pago);
    List<Pago> listarPagos();
    Pago buscarPorId(int idPago);

    //Listar por contrato según lo establecido en los diagramas de clase con relación de 1 a muchos
    List<Pago> buscarPorContrato(int idContrato);

    void actualizarPago(Pago pago);
}
