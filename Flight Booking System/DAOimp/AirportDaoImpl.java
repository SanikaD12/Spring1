package com.flight.daoimp;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.flight.Dao.AirportDao;
import com.flight.entity.Airport;
import com.flight.util.HibernateUtil;

public class AirportDaoImpl implements AirportDao {
	
	
	

   

    @Override
    public void saveAirport(Airport airport) {
    	Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.saveOrUpdate(airport);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    
    public List<Airport> getAllAirports() {
    	
        Transaction tx = null;
        List<Airport> airports = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            airports = session.createQuery("FROM Airport", Airport.class).list();
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
        return airports;
    }

    @Override
    public Airport getAirportById(int id) {
    	Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            return session.get(Airport.class, id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    @Override
    public boolean deleteAirport(int airportId) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Airport airport = session.get(Airport.class, airportId);
            if (airport != null) {
                tx = session.beginTransaction();
                session.delete(airport);
                tx.commit();
                return true;
            }
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
        return false;
    }

}
