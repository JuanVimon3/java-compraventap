package com.compraventapropiedades.dao.interfaces;

import com.compraventapropiedades.model.Propiedad;
import java.util.List;

public interface PropiedadDAOInterface {
    //CRUD
    void insertarPropiedad(Propiedad propiedad);
    List<Propiedad> listarPropiedades();
    Propiedad buscarPorId(int idPropiedad);
    void actualizarPropiedad(Propiedad propiedad);
    void eliminarPropiedad(int idPropiedad);
}
