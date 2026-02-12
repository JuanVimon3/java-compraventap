package com.compraventapropiedades;

import com.compraventapropiedades.dao.PropiedadDAO;
import com.compraventapropiedades.dao.UsuarioDAO;
import com.compraventapropiedades.model.Propiedad;
import com.compraventapropiedades.model.Usuario;
import java.util.List;

public class App 
{
    public static void main( String[] args )
    {
        UsuarioDAO uDAO = new UsuarioDAO();
        PropiedadDAO pDAO = new PropiedadDAO();

        
        Usuario u = new Usuario(1, 123, "email@test.com", "Juan", "password123");
       
        
        uDAO.insertarUsuario(u);

        // Listar usuarios
        List<Usuario> lista = uDAO.listarUsuarios();

        
        if (!lista.isEmpty()) {
            int idGenerado = lista.get(0).getIdUsuario();

            // 4. Insertar nueva propiedad usando el ID del usuario 
            Propiedad nuevaPropiedad = new Propiedad(0, "Calle 32 123 San Javier", 7800000, idGenerado);
            pDAO.insertarPropiedad(nuevaPropiedad);

            // 5. Eliminar 
            
            
            System.out.println("Prueba de lógica completada con éxito.");
        } else {
            System.out.println("La lista de usuarios está vacía.");
        }
    }
}