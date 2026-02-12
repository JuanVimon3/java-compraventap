<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.compraventapropiedades.model.Usuario"%>
<%
    // Lógica de seguridad: Recuperar objeto de la sesión
    Usuario user = (Usuario) session.getAttribute("usuarioSesion");
    
    // Si no hay nadie logueado, lo mandamos al index
    if (user == null) {
        response.sendRedirect("index.jsp");
        return;
    }
%>
<!DOCTYPE html>
<html>
<head>
    <title>Panel Principal - Compraventa</title>
</head>
<body>
    <h1>Bienvenido, <%= user.getNombre() %></h1>
    <p>Has ingresado al sistema de gestión de propiedades.</p>
    <p>Tu correo es: <%= user.getEmail() %></p>
    
    <hr>
    <a href="LogoutServlet">Cerrar Sesión</a>
</body>
</html>