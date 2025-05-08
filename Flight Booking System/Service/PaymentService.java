package com.flight.service;

import java.util.List;


import com.flight.entity.Payment;

public interface PaymentService {
	
	void processPayment(Payment payment);
    Payment getPaymentById(int id);

}
