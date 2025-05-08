package com.flight.serviceimpl;

import com.flight.entity.Payment;
import com.flight.service.PaymentService;

import java.util.List;

import com.flight.Dao.PaymentDao;
import com.flight.daoimp.PaymentDaoImpl;

public class PaymentServiceImpl implements PaymentService{
	
	private PaymentDao paymentDAO;

    public PaymentServiceImpl(PaymentDao paymentDAO) {
        this.paymentDAO = paymentDAO;
    }

    @Override
    public void processPayment(Payment payment) {
        // Business logic to validate payment before processing
        paymentDAO.savePayment(payment);
    }

    @Override
    public Payment getPaymentById(int id) {
        return paymentDAO.getPaymentById(id);
    }
}
