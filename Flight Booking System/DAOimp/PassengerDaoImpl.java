package com.flight.daoimp;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.flight.Dao.PassengerDao;
import com.flight.entity.Passenger;
import com.flight.util.HibernateUtil;
import org.hibernate.query.Query;

public class PassengerDaoImpl implements PassengerDao {
	public void savePassenger(Passenger passenger) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.save(passenger);
        tx.commit();
        session.close();
    }

    public Passenger getPassengerById(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Passenger p = session.get(Passenger.class, id);
        session.close();
        return p;
    }

    public Passenger getPassengerByEmail(String email) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query<Passenger> query = session.createQuery("FROM Passenger WHERE email = :email", Passenger.class);
        query.setParameter("email", email);
        Passenger p = query.uniqueResult();
        session.close();
        return p;
    }

    public List<Passenger> getAllPassengers() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Passenger> list = session.createQuery("FROM Passenger", Passenger.class).list();
        session.close();
        return list;
    }
    
    public Passenger login(String email, String password) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Passenger> query = session.createQuery("FROM Passenger WHERE email = :email AND password = :password", Passenger.class);
            query.setParameter("email", email);
            query.setParameter("password", password);
            return query.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
