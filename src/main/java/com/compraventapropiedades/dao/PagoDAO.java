package com.compraventapropiedades.dao;

import com.compraventapropiedades.dao.interfaces.PagoDAOInterface;
import com.compraventapropiedades.database.HibernateUtil;
import com.compraventapropiedades.model.Pago;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import java.util.List;

public class PagoDAO implements PagoDAOInterface {
    
    @Override
    public void registrarPago(Pago pago){
        Transaction transaction = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            // Se registra el pago
            session.persist(pago);
            // Se confirma y envía el pago
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    @Override
    public List<Pago> listarPagos(){
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            return session.createQuery("from Pago", Pago.class).list();
        }
    }

    @Override
    public Pago buscarPorId(int idPago){
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            return session.get(Pago.class, idPago);
        }
    }

    @Override
    public List<Pago> buscarPorContrato(int idContrato){
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            // Se usa HQL para navega desde Pago a Contrato por medio de su FK para obtener el contrato asociado
            String hql = "FROM Pago p WHERE p.contrato.idContrato = :idCon";
            Query<Pago> query = session.createQuery(hql, Pago.class);
            query.setParameter("idCon", idContrato);
            return query.list();
        }
    }

    @Override
    public void actualizarPago(Pago pago){
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.merge(pago);
            transaction.commit();
        } catch (Exception e) {
            if(transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

}
