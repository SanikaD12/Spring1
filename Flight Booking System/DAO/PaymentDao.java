package com.flight.Dao;

import java.util.List;

import com.flight.entity.Payment;

public interface PaymentDao {

	void savePayment(Payment payment);
    Payment getPaymentById(int id);
}
