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
        
        String sql = "INSERT INTO Usuario (cedula, email, nombre, contraseña) VALUES (?, ?, ?, ?)";

        try (Connection con = Conexion.conectar(); 
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, usuario.getCedula());
            ps.setString(2, usuario.getEmail());
            ps.setString(3, usuario.getNombre());
            ps.setString(4, usuario.getContraseña()); // Nuevo

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
                    rs.getString("nombre"),
                    rs.getString("contraseña") // Nuevo
                );
                usuarios.add(usuario);
            }

        } catch(Exception e){
            System.out.println("Error al listar usuarios: " + e.getMessage());
        }
        return usuarios;
    }

    public void actualizarUsuario(Usuario usuario){
        
        String sql = "UPDATE Usuario SET cedula = ?, email = ?, nombre = ?, contraseña = ? WHERE idUsuario = ?";

        try(Connection con = Conexion.conectar();
            PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, usuario.getCedula());
            ps.setString(2, usuario.getEmail());
            ps.setString(3, usuario.getNombre());
            ps.setString(4, usuario.getContraseña()); // Nuevo
            ps.setInt(5, usuario.getIdUsuario());

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

    public Usuario validar(String email, String pass) {
        Usuario user = null;
        String sql = "SELECT * FROM Usuario WHERE email = ? AND contraseña = ?";

        try (Connection con = Conexion.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {
            
            ps.setString(1, email);
            ps.setString(2, pass);
            
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    user = new Usuario();
                    user.setIdUsuario(rs.getInt("idUsuario")); 
                    user.setNombre(rs.getString("nombre"));
                    user.setEmail(rs.getString("email"));
                    user.setCedula(rs.getInt("cedula"));
                    user.setContraseña(rs.getString("contraseña")); 
                }
            }
        } catch (Exception e) {
            System.out.println("Error en validación: " + e.getMessage());
        } 
        return user;
    }
}