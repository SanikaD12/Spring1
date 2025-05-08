package com.flight.daoimp;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.flight.Dao.AdminDao;
import com.flight.entity.Admin;
import com.flight.util.HibernateUtil;

public class AdminDaoImpl implements AdminDao {

	private Session session;

    public AdminDaoImpl() {
        session = HibernateUtil.getSessionFactory().openSession();
    }

    @Override
    public void addAdmin(Admin admin) {
        Transaction tx = session.beginTransaction();
        session.save(admin);
        tx.commit();
    }

    @Override
    public Admin getAdminByEmailAndPassword(String email, String password) {
        String hql = "FROM Admin WHERE email = :email AND password = :password";
        Query<Admin> query = session.createQuery(hql, Admin.class);
        query.setParameter("email", email);
        query.setParameter("password", password);

        Admin admin = query.uniqueResult();
        return admin;
    }

	
	
}
