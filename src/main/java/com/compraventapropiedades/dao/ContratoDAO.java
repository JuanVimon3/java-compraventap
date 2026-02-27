package com.compraventapropiedades.dao;

import com.compraventapropiedades.database.HibernateUtil;
import com.compraventapropiedades.model.Contrato;
import com.compraventapropiedades.dao.interfaces.ContratoDAOInterface;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;

public class ContratoDAO implements ContratoDAOInterface {

    @Override
    public void generarContrato(Contrato contrato) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.persist(contrato);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null)
                transaction.rollback(); // Si hay un error, se regresa la acción para no dañar la BD
            e.printStackTrace(); // Se muestra en qué se falló
        }
    }

    @Override
    public List<Contrato> listarContratos() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Contrato", Contrato.class).list();
            // Se usa HQL, en vez de SQL para hacer la consulta de la entidad
        }
    }

    @Override
    public List<Contrato> listarPorVendedor(int idVendedor) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // Se usa HQL para filtrar por el ID del objeto vendedor que está dentro del
            // contrato
            String hql = "from Contrato c where c.vendedor.idVendedor = :id"; // id: es un marcador de posición, que se
                                                                              // pasa por setParameter()
            return session.createQuery(hql, Contrato.class)
                    .setParameter("id", idVendedor)
                    .list();
        }
    }

    @Override
    public Contrato buscarPorId(int idContrato) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Contrato.class, idContrato);
        }
    }

    @Override
    public void cancelarContrato(int idContrato) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Contrato c = session.get(Contrato.class, idContrato);
            if (c != null) {
                session.remove(c);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null)
                transaction.rollback();
            e.printStackTrace();
        }
    }
}