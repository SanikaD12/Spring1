package com.flight.daoimp;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.flight.Dao.PaymentDao;
import com.flight.entity.Payment;
import com.flight.util.HibernateUtil;

public class PaymentDaoImpl implements PaymentDao {
	
	public void savePayment(Payment payment) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.save(payment);
        tx.commit();
        session.close();
    }

    public Payment getPaymentById(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Payment p = session.get(Payment.class, id);
        session.close();
        return p;
    }

}
