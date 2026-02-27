package com.compraventapropiedades.controller;

import com.compraventapropiedades.dao.PropiedadDAO;
import com.compraventapropiedades.dao.UsuarioDAO;
import com.compraventapropiedades.dao.interfaces.PropiedadDAOInterface;
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

    private PropiedadDAOInterface propiedadDAO = new PropiedadDAO();
    private UsuarioDAO usuarioDAO = new UsuarioDAO();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        // 1. Obtener parámetros del formulario
        String accion = request.getParameter("accion");
        String ubicacion = request.getParameter("ubicacion");
        String precioStr = request.getParameter("precio");
        
        String idUsuarioStr = request.getParameter("idUsuario"); 

        try {
            if ("insertar".equals(accion)) {
                // 2. Conversión de datos
                int precio = Integer.parseInt(precioStr);
                int idUsuario = Integer.parseInt(idUsuarioStr);

                // 3. Buscar el objeto Usuario (dueño o propietario, aquí usaremos "owner")
                Usuario usuarioOwner = usuarioDAO.buscarPorId(idUsuario);

                if (usuarioOwner != null) {
                    // 4. Construir el objeto Propiedad
                    Propiedad nuevaPropiedad = new Propiedad();
                    nuevaPropiedad.setUbicacion(ubicacion);
                    nuevaPropiedad.setPrecio(precio);
                    
                    
                    nuevaPropiedad.setUsuario(usuarioOwner); 

                    // 5. Guardar
                    propiedadDAO.insertarPropiedad(nuevaPropiedad);
                }
            }
            // 6. Redirigir al panel 
            response.sendRedirect("panel.jsp");

        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("error.jsp");
        }
    }
}