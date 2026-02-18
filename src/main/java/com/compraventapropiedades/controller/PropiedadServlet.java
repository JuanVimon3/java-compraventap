package com.compraventapropiedades.controller;

import com.compraventapropiedades.dao.PropiedadDAO;
import com.compraventapropiedades.dao.UsuarioDAO;
import com.compraventapropiedades.model.Propiedad;
import com.compraventapropiedades.model.Usuario;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/PropiedadServlet") 
public class PropiedadServlet extends HttpServlet {

    private PropiedadDAO propiedadDAO = new PropiedadDAO();
    private UsuarioDAO usuarioDAO = new UsuarioDAO();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        // 1. Obtener parámetros del formulario
        String accion = request.getParameter("accion");
        String ubicacion = request.getParameter("ubicacion");
        String precioStr = request.getParameter("precio");
        String idDuenoStr = request.getParameter("idUsuarioDueno");

        try {
            if ("insertar".equals(accion)) {
                // 2. Conversión de datos
                int precio = Integer.parseInt(precioStr);
                int idDueno = Integer.parseInt(idDuenoStr);

                // 3. El paso clave de Hibernate: Buscar el objeto Usuario
                Usuario dueno = usuarioDAO.buscarPorId(idDueno);

                if (dueno != null) {
                    // 4. Construir el objeto Propiedad
                    Propiedad nuevaPropiedad = new Propiedad();
                    nuevaPropiedad.setUbicacion(ubicacion);
                    nuevaPropiedad.setPrecio(precio);
                    nuevaPropiedad.setDueno(dueno);

                    // 5. Guardar
                    propiedadDAO.insertarPropiedad(nuevaPropiedad);
                }
            }
            // 6. Redirigir al panel para ver los cambios
            response.sendRedirect("panel.jsp");

        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("error.jsp");
        }
    }
}