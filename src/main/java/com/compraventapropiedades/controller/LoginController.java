package com.compraventapropiedades.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

import com.compraventapropiedades.dao.UsuarioDAO;
import com.compraventapropiedades.model.Usuario;

@WebServlet("/LoginController") 
public class LoginController extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response )
    throws ServletException, IOException
    {
        String email = request.getParameter("txtEmail");
        String clave = request.getParameter("txtPass"); 

        UsuarioDAO usuarioDao = new UsuarioDAO();
        Usuario user = usuarioDao.validar(email, clave);

        if(user != null){
            HttpSession session = request.getSession();
            session.setAttribute("usuarioSesion", user);

            response.sendRedirect("panel.jsp");
        } else {
            request.setAttribute("mensajeError", "Correo o contraseña incorrectos.");
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
        
    }
}
