package com.compraventapropiedades.dao;

import com.compraventapropiedades.database.Conexion;
import com.compraventapropiedades.model.Propiedad;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PropiedadDAO {

    public void insertarPropiedad(Propiedad propiedad) {
        String sql = "INSERT INTO Propiedad (ubicacion, precio, idUsuarioDueno) VALUES (?,?,?)";

        try (Connection con = Conexion.conectar();
                PreparedStatement ps = con.prepareStatement(sql);) {

            ps.setString(1, propiedad.getUbicacion());
            ps.setInt(2, propiedad.getPrecio());
            ps.setObject(3, propiedad.getIdUsuarioDueno());

            ps.executeUpdate();
            System.out.println("Propiedad registrada correctamente");

        } catch (Exception e) {
            System.out.println("Error al registrar la propiedad: " + e.getMessage());
        }
    }

    public List<Propiedad> listarPropiedades() {
        List<Propiedad> propiedades = new ArrayList<>();
        String sql = "SELECT * FROM Propiedad";

        try (Connection con = Conexion.conectar();
                PreparedStatement ps = con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();) {

            while (rs.next()) {
                Propiedad propiedad = new Propiedad(
                        rs.getInt("idPropiedad"),
                        rs.getString("ubicacion"),
                        rs.getInt("precio"),
                        rs.getObject("idUsuarioDueno", Integer.class));

                propiedades.add(propiedad);

            }

        } catch (Exception e) {
            System.out.println("Error al listar propiedades: " + e.getMessage());
        }
        return propiedades;
    }

    public void actualizarPropiedad(Propiedad propiedad) {
        String sql = "UPDATE Propiedad SET ubicacion = ?, precio = ?, idUsuarioDueno = ? WHERE idPropiedad = ?";

        try (Connection con = Conexion.conectar();
                PreparedStatement ps = con.prepareStatement(sql);) {
            ps.setString(1, propiedad.getUbicacion());
            ps.setInt(2, propiedad.getPrecio());
            ps.setObject(3, propiedad.getIdUsuarioDueno());
            ps.setInt(4, propiedad.getIdPropiedad());

            ps.executeUpdate();
            System.out.println("Propiedad actualizada correctamente");

        } catch (Exception e) {
            System.out.println("Error al actualizar la propiedad: " + e.getMessage());
        }
    }

    public void eliminarPropiedad(int idPropiedad) {
        String sql = "DELETE FROM Propiedad WHERE idPropiedad = ?";

        try (Connection con = Conexion.conectar();
                PreparedStatement ps = con.prepareStatement((sql));) {

            ps.setInt(1, idPropiedad);
            ps.execute();

            System.out.println("Propiedad borrada correctamente");

        } catch (Exception e) {
            System.out.println("Error al eliminar la propiedad" + e.getMessage());
        }
    }
}
