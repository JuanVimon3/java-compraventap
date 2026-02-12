<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Login - Compra Venta Propiedades</title>
</head>
<body>
    <h2>Iniciar Sesión</h2>
    
   
    <p style="color: red;">${mensajeError}</p>

     <form action="LoginController" method="POST">
        <label>Email:</label>
        <input type="email" name="txtEmail" required><br>
        
        <label>Contraseña:</label>
        <input type="password" name="txtPass" required><br>
        
        <button type="submit">Entrar</button>
    </form>
</body>
</html>