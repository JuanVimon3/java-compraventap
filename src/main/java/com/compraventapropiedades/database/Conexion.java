package com.compraventapropiedades.database;

import java.sql.Connection;
import java.sql.DriverManager;


public class Conexion {
    private static final String URL = "jdbc:mysql://localhost:3306/compra_venta_propiedades";
    private static final String USER = "root";
    private static final String PASS = "Dracov3@2025";

    public static Connection conectar() {
        Connection con = null;

        try {
            con = DriverManager.getConnection(URL, USER, PASS);
            System.out.println("Conexión exitosa a la base de datos de compra y venta de propiedades");
        } catch (Exception e) {
            System.out.println("Error: conexión fallida " + e.getMessage());;
        }

        return con;
    }
}
