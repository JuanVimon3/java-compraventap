package com.compraventapropiedades.dao;

// Se modifican las importaciones para trabajar con Hibernat

import com.compraventapropiedades.database.HibernateUtil;
import com.compraventapropiedades.model.Usuario;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import java.util.List;

public class UsuarioDAO {

    // Insertar con Hibernate
    public void insertarUsuario(Usuario usuario) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.persist(usuario); 
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    // Listar con Hibernate
    public List<Usuario> listarUsuarios() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Usuario", Usuario.class).list();
        }
    }

    // Actualizar con Hibernate
    public void actualizarUsuario(Usuario usuario) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.merge(usuario);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    // Eliminar con Hibernate
    public void eliminarUsuario(int idUsuario) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Usuario usuario = session.get(Usuario.class, idUsuario);
            if (usuario != null) {
                session.remove(usuario);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    // Validar(Login) con Hibernate 
    public Usuario validar(String email, String pass) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "FROM Usuario WHERE email = :email AND contraseña = :password";
            Query<Usuario> query = session.createQuery(hql, Usuario.class);
            query.setParameter("email", email);
            query.setParameter("password", pass); 
            return query.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}

// package com.compraventapropiedades.dao;

// import com.compraventapropiedades.database.Conexion;
// import com.compraventapropiedades.model.Usuario;

// import java.sql.Connection;
// import java.sql.PreparedStatement;
// import java.sql.ResultSet;
// import java.util.ArrayList;
// import java.util.List;
// import com.compraventapropiedades.database.HibernateUtil;
// import com.compraventapropiedades.model.Usuario;
// import org.hibernate.Session;
// import org.hibernate.query.Query;

// public class UsuarioDAO {

//     public void insertarUsuario(Usuario usuario) {
        
//         String sql = "INSERT INTO Usuario (cedula, email, nombre, contraseña) VALUES (?, ?, ?, ?)";

//         try (Connection con = Conexion.conectar(); 
//              PreparedStatement ps = con.prepareStatement(sql)) {

//             ps.setInt(1, usuario.getCedula());
//             ps.setString(2, usuario.getEmail());
//             ps.setString(3, usuario.getNombre());
//             ps.setString(4, usuario.getContraseña()); // Nuevo

//             ps.executeUpdate();
//             System.out.println("Usuario registrado correctamente");

//         } catch (Exception e) {
//             System.out.println("Error al registrar el usuario: " + e.getMessage());
//         }
//     }

//     public List<Usuario> listarUsuarios(){
//         List<Usuario> usuarios = new ArrayList<>();
//         String sql = "SELECT * FROM Usuario";

//         try(Connection con = Conexion.conectar(); 
//             PreparedStatement ps = con.prepareStatement(sql); 
//             ResultSet rs = ps.executeQuery()){
            
//             while (rs.next()) {
               
//                 Usuario usuario = new Usuario(
//                     rs.getInt("idUsuario"), 
//                     rs.getInt("cedula"),
//                     rs.getString("email"),
//                     rs.getString("nombre"),
//                     rs.getString("contraseña") // Nuevo
//                 );
//                 usuarios.add(usuario);
//             }

//         } catch(Exception e){
//             System.out.println("Error al listar usuarios: " + e.getMessage());
//         }
//         return usuarios;
//     }

//     public void actualizarUsuario(Usuario usuario){
        
//         String sql = "UPDATE Usuario SET cedula = ?, email = ?, nombre = ?, contraseña = ? WHERE idUsuario = ?";

//         try(Connection con = Conexion.conectar();
//             PreparedStatement ps = con.prepareStatement(sql)) {

//             ps.setInt(1, usuario.getCedula());
//             ps.setString(2, usuario.getEmail());
//             ps.setString(3, usuario.getNombre());
//             ps.setString(4, usuario.getContraseña()); // Nuevo
//             ps.setInt(5, usuario.getIdUsuario());

//             ps.executeUpdate();
//             System.out.println("Usuario actualizado correctamente");

//         } catch (Exception e) {
//             System.out.println("Error al actualizar el usuario: " + e.getMessage());
//         }
//     }

//     public void eliminarUsuario(int idUsuario){
//         String sql = "DELETE FROM Usuario WHERE idUsuario = ?";
//         try (Connection con = Conexion.conectar();
//             PreparedStatement ps = con.prepareStatement(sql)) {
//             ps.setInt(1, idUsuario);
//             ps.executeUpdate();
//             System.out.println("Usuario borrado correctamente");
//         } catch (Exception e) {
//             System.out.println("Error al eliminar el usuario: " + e.getMessage());
//         }
//     }

//     public Usuario validar(String email, String pass) {
//         Usuario user = null;
//         String sql = "SELECT * FROM Usuario WHERE email = ? AND contraseña = ?";

//         try (Connection con = Conexion.conectar();
//              PreparedStatement ps = con.prepareStatement(sql)) {
            
//             ps.setString(1, email);
//             ps.setString(2, pass);
            
//             try (ResultSet rs = ps.executeQuery()) {
//                 if (rs.next()) {
//                     user = new Usuario();
//                     user.setIdUsuario(rs.getInt("idUsuario")); 
//                     user.setNombre(rs.getString("nombre"));
//                     user.setEmail(rs.getString("email"));
//                     user.setCedula(rs.getInt("cedula"));
//                     user.setContraseña(rs.getString("contraseña")); 
//                 }
//             }
//         } catch (Exception e) {
//             System.out.println("Error en validación: " + e.getMessage());
//         } 
//         return user;
//     }
// }