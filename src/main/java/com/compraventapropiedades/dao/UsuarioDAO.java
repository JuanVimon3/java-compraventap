package com.compraventapropiedades.dao;

import com.compraventapropiedades.database.Conexion;
import com.compraventapropiedades.model.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {

    public void insertarUsuario(Usuario usuario){
        String sql = "INSERT INTO usuarios (cedula, email, nombre) VALUES (?, ?, ?)";

        try(Connection con = Conexion.conectar() ){

            PreparedStatement ps = con.prepareStatement(sql); 
            
            {
                ps.setInt(1, usuario.getCedula());
                ps.setString(2, usuario.getEmail());
                ps.setString(3, usuario.getNombre());

                ps.executeUpdate();
                System.out.println("Usuario registrado correctamente");
            }


        }catch(Exception e){
            System.out.println("Error al registrar el usuario" + e.getMessage());
        }
    }
}
