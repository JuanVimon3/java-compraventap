package com.compraventapropiedades.dao.interfaces;

import com.compraventapropiedades.model.Vendedor;
import java.util.List;

public interface VendedorDAOInterface {
    // CRUD
    void guardarVendedor(Vendedor vendedor);
    List<Vendedor> listarVendedores();
    Vendedor buscarPorId(int idVendedor);
    void eliminarVendedor(int idVendedor);
    void actualizarVendedor(Vendedor vendedor);
}