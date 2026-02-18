<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.compraventapropiedades.model.Propiedad"%>
<%@page import="com.compraventapropiedades.dao.PropiedadDAO"%>
<%@page import="java.util.List"%>
<%@page import="com.compraventapropiedades.model.Usuario"%>
<%
    // Lógica de seguridad: Recuperar objeto de la sesión
    Usuario user = (Usuario) session.getAttribute("usuarioSesion");
    
    // Si no hay nadie logueado, se manda al index
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

    <hr>
    <h2>Registrar Nueva Propiedad</h2>
    <form action="PropiedadServlet" method="post">
        <input type="hidden" name="accion" value="insertar">

        <label>Ubicación:</label>
        <input type="text" name="ubicacion" required><br><br>

        <label>Precio:</label>
        <input type="number" name="precio" required><br><br>

        <%-- Enviar el ID del usuario de la sesión actual --%>
        <input type="hidden" name="idUsuarioDueno" value="<%= user.getIdUsuario() %>">

        <button type="submit">Guardar Propiedad</button>
    </form>

    <hr>
    <h2>Mis Propiedades</h2>
    <table border="1">
        <thead>
            <tr>
                <th>ID</th>
                <th>Ubicación</th>
                <th>Precio</th>
            </tr>
        </thead>
        <tbody>
            <%
                PropiedadDAO pDAO = new PropiedadDAO();
                List<Propiedad> lista = pDAO.listarPropiedades();
                for(Propiedad p : lista) {
            %>
            <tr>
                <td><%= p.getIdPropiedad() %></td>
                <td><%= p.getUbicacion() %></td>
                <td><%= p.getPrecio() %></td>
            </tr>
            <% } %>
        </tbody>
    </table>
</body>
</html>