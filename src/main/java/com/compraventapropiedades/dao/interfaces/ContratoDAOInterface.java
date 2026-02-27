package com.compraventapropiedades.dao.interfaces;

import com.compraventapropiedades.model.Contrato;
import java.util.List;

public interface ContratoDAOInterface {
    void generarContrato(Contrato contrato);
    List<Contrato>listarContratos();
    List<Contrato>listarPorVendedor(int idVendedor);//para listar los usuarios vendedores
    Contrato buscarPorId(int idContrato);
    void cancelarContrato(int idContrato);
}
