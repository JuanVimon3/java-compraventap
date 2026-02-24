package com.compraventapropiedades.dao;

import com.compraventapropiedades.model.Vendedor;
import com.compraventapropiedades.database.HibernateUtil;
import com.compraventapropiedades.dao.interfaces.VendedorDAOInterface;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;

public class VendedorDAO implements VendedorDAOInterface {

    @Override
    public void guardarVendedor(Vendedor vendedor) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.persist(vendedor);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    @Override
    public List<Vendedor> listarVendedores() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Vendedor", Vendedor.class).list();
        }
    }

    @Override
    public Vendedor buscarPorId(int idVendedor) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Vendedor.class, idVendedor);
        }
    }

    @Override
    public void eliminarVendedor(int idVendedor) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Vendedor v = session.get(Vendedor.class, idVendedor);
            if (v != null) {
                session.remove(v);
                transaction.commit();
            }
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    @Override
    public void actualizarVendedor(Vendedor vendedor) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.merge(vendedor);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }
}