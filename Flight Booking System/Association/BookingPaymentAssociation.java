package com.flight.association;

import com.flight.entity.Booking;
import com.flight.entity.Payment;

public class BookingPaymentAssociation {

	private Booking booking;
    private Payment payment;

    public BookingPaymentAssociation(Booking booking, Payment payment) {
        this.booking = booking;
        this.payment = payment;
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    @Override
    public String toString() {
        return "BookingPaymentAssociation{" +
                "booking=" + booking +
                ", payment=" + payment +
                '}';
    }
}
