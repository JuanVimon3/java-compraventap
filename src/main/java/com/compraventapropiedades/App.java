package com.compraventapropiedades;

import com.compraventapropiedades.dao.PropiedadDAO;
import com.compraventapropiedades.dao.UsuarioDAO;
import com.compraventapropiedades.model.Propiedad;
import com.compraventapropiedades.model.Usuario;
import java.util.List;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        UsuarioDAO uDAO = new UsuarioDAO();
        PropiedadDAO pDAO = new PropiedadDAO();

        Usuario nuevoUsuario = new Usuario(0, 15455678, "pepito123@gmail.com", "Pepito Pérez" );
       
        // Insertar un nuevo usuario
        uDAO.insertarUsuario(nuevoUsuario);

        // Leer o listar usuarios
        uDAO.listarUsuarios();

        // Crear una lista para ver usuarios

        List<Usuario> lista = uDAO.listarUsuarios();

        int idPepito = lista.get(0).getIdUsuario();

        // Insertar nueva propiedad

        Propiedad nuevaPropiedad = new Propiedad(0, "Calle 32 123 San Javier", 7800000, idPepito);
        pDAO.insertarPropiedad(nuevaPropiedad);

        // Eliminar propiedad

        pDAO.eliminarPropiedad(idPepito);

        //Eliminar usuario

        uDAO.eliminarUsuario(idPepito); // En caso de que queramos borrar el usuario de Pepito Pérez


    }
}
