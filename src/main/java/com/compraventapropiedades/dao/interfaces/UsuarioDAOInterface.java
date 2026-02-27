package com.compraventapropiedades.dao.interfaces;

import com.compraventapropiedades.model.Usuario;
import java.util.List;

public interface UsuarioDAOInterface {
    //Funciones del CRUD
    void insertarUsuario(Usuario usuario);
    List<Usuario> listarUsuarios();
    void actualizarUsuario(Usuario usuario);
    void eliminarUsuario(int idUsuario);
    Usuario validar(String email, String pass);
    Usuario buscarPorId(int idUsuario);
}
