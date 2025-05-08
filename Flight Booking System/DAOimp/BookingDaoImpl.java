package com.flight.daoimp;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.flight.Dao.BookingDao;
import com.flight.entity.Booking;
import com.flight.util.HibernateUtil;

import org.hibernate.query.Query;
public class BookingDaoImpl implements BookingDao {
	
	public void saveBooking(Booking booking) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(booking);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public Booking getBookingById(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Booking booking = null;
        try {
            booking = session.get(Booking.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return booking;
    }

    public List<Booking> getBookingsByPassengerId(int passengerId) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Booking> bookings = null;
        try {
            Query<Booking> query = session.createQuery("FROM Booking WHERE passenger.id = :pid", Booking.class);
            query.setParameter("pid", passengerId);
            bookings = query.list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return bookings;
    }

    public void cancelBooking(int bookingId) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Booking booking = session.get(Booking.class, bookingId);
            if (booking != null) {
                booking.setStatus("Canceled");
                session.update(booking);
            }
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public List<Booking> getAllBookings() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Booking> bookings = null;
        try {
            bookings = session.createQuery("FROM Booking", Booking.class).list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return bookings;
    }
    
    @Override
    public void updateBooking(Booking booking) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            session.update(booking);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
    }

    
}
