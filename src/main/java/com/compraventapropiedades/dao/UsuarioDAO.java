package com.compraventapropiedades.dao;

import com.compraventapropiedades.database.Conexion;
import com.compraventapropiedades.model.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {

    public void insertarUsuario(Usuario usuario) {
        
        String sql = "INSERT INTO Usuario (cedula, email, nombre) VALUES (?, ?, ?)";

       
        try (Connection con = Conexion.conectar(); 
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, usuario.getCedula());
            ps.setString(2, usuario.getEmail());
            ps.setString(3, usuario.getNombre());

            ps.executeUpdate();
            System.out.println("Usuario registrado correctamente");

        } catch (Exception e) {
            System.out.println("Error al registrar el usuario: " + e.getMessage());
        }
    }

    public List<Usuario> listarUsuarios(){
        List<Usuario> usuarios = new ArrayList<>();
        String sql = "SELECT * FROM Usuario";

        try(Connection con = Conexion.conectar(); 
            PreparedStatement ps = con.prepareStatement(sql); 
            ResultSet rs = ps.executeQuery()){
            
            while (rs.next()) {
                Usuario usuario = new Usuario(
                    rs.getInt("idUsuario"), 
                    rs.getInt("cedula"),
                    rs.getString("email"),
                    rs.getString("nombre")
                );
                usuarios.add(usuario);
            }

        } catch(Exception e){
            System.out.println("Error al listar usuarios: " + e.getMessage());
        }
        return usuarios;
    }

    public void actualizarUsuario(Usuario usuario){
        
        String sql = "UPDATE Usuario SET cedula = ?, email = ?, nombre = ? WHERE idUsuario = ?";

        try(Connection con = Conexion.conectar();
            PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, usuario.getCedula());
            ps.setString(2, usuario.getEmail());
            ps.setString(3, usuario.getNombre());
            ps.setInt(4, usuario.getIdUsuario());

            ps.executeUpdate();
            System.out.println("Usuario actualizado correctamente");

        } catch (Exception e) {
            System.out.println("Error al actualizar el usuario: " + e.getMessage());
        }
    }

    public void eliminarUsuario(int idUsuario){
    
    String sql = "DELETE FROM Usuario WHERE idUsuario = ?";

    
    try (Connection con = Conexion.conectar();
         PreparedStatement ps = con.prepareStatement(sql)) {

        ps.setInt(1, idUsuario);
        ps.executeUpdate();

        System.out.println("Usuario borrado correctamente");

    } catch (Exception e) {
        System.out.println("Error al eliminar el usuario: " + e.getMessage());
    }
}
}