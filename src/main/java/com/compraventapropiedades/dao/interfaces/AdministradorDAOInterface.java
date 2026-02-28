package com.compraventapropiedades.dao.interfaces;

import com.compraventapropiedades.model.Administrador;
import java.util.List;

public interface AdministradorDAOInterface {
    // Funciones del CRUD   
    void instertarAdministrador(Administrador administrador);
    List<Administrador> listarAdministrador();
    void actualizarAdministrador(Administrador administrador);
    void eliminarAdministrador(int idAdministrador);
    Administrador validarAdministrador(String email, String pass);
    Administrador buscarPorId(int idAdministrador);
}
