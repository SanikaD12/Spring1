package com.flight.daoimp;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.flight.Dao.FlightDao;
import com.flight.entity.Flight;
import com.flight.util.HibernateUtil;
import org.hibernate.query.Query;

public class FlightDaoImpl implements FlightDao {

	public void saveFlight(Flight flight) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.save(flight);
        tx.commit();
        session.close();
    }

    public Flight getFlightById(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Flight f = session.get(Flight.class, id);
        session.close();
        return f;
    }

    public List<Flight> getAllFlights() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Flight> list = session.createQuery("FROM Flight", Flight.class).list();
        session.close();
        return list;
    }

    public List<Flight> searchFlights(String source, String destination) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query<Flight> query = session.createQuery("FROM Flight WHERE source = :src AND destination = :dst", Flight.class);
        query.setParameter("src", source);
        query.setParameter("dst", destination);
        List<Flight> list = query.list();
        session.close();
        return list;
    }
    @Override
    public boolean deleteFlight(int flightId) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Flight flight = session.get(Flight.class, flightId);
            if (flight != null) {
                tx = session.beginTransaction();
                session.delete(flight);
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
