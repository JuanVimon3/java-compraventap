package com.compraventapropiedades.dao;

import com.compraventapropiedades.dao.interfaces.AdministradorDAOInterface;

import com.compraventapropiedades.database.HibernateUtil;
import com.compraventapropiedades.model.Administrador;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import java.util.List;

public class AdministradorDAO implements AdministradorDAOInterface {
    //Insertar
    @Override
    public void instertarAdministrador (Administrador administrador){
        Transaction transaction = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.persist(administrador);
            transaction.commit();
        } catch (Exception e) {
            if(transaction != null)transaction.rollback();
            e.printStackTrace();
        }
    }
    // Listar 
    @Override
    public List<Administrador> listarAdministrador(){
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            return session.createQuery("from Administrador", Administrador.class).list();
        }
    }
    //Actualizar
    @Override
    public void actualizarAdministrador(Administrador administrador){
        Transaction transaction = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            session.merge(administrador);
            transaction.commit();
        }
    }
    //Eliminar
    @Override
    public void eliminarAdministrador(int idAdministrador){
        Transaction transaction = null;
        try(Session session =  HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            Administrador administrador = session.get(Administrador.class, idAdministrador);
            if(administrador != null){
                session.remove(administrador);
            }
            transaction.commit();
        } catch (Exception e) {
            if(transaction != null)transaction.rollback();
            e.printStackTrace();
        }
    }
    //Validar
    @Override
    public Administrador validarAdministrador(String email, String pass){
        Transaction transaction = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            String hql = "FROM Administrador WHERE email = :email AND contraseña = :pass";

            Query<Administrador> query = session.createQuery(hql, Administrador.class);

            query.setParameter("email", email);
            query.setParameter("pass", pass); 

            return query.uniqueResult();

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    //Buscar por Id
    @Override
    public Administrador buscarPorId(int idAdministrador){
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Administrador.class, idAdministrador);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
