package com.flight.entity;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Payment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="payment_ID")
	private int paymentId;
	
	@Column(name="Payment_Date")
	private LocalDate paymentDate;
	
	@Column(name="Payment_Method")
	private String paymentMethod;
	
	@Column(name="Amount")
	private double amount;
	
	@Column(name="Status")
	private String status;
	
	@OneToOne(cascade = {CascadeType.MERGE,CascadeType.PERSIST})
	@JoinColumn(name = "Booking_ID")
	private Booking booking;
	public int getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}
	public LocalDate getPaymentDate() {
		return paymentDate;
	}
	public void setPaymentDate(LocalDate localDate) {
		this.paymentDate = localDate;
	}
	public String getPaymentMethod() {
		return paymentMethod;
	}
	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Booking getBooking() {
		return booking;
	}
	public void setBooking(Booking booking) {
		this.booking = booking;
	}
	public Payment(int paymentId, LocalDate paymentDate, String paymentMethod, double amount, String status,
			Booking booking) {
		super();
		this.paymentId = paymentId;
		this.paymentDate = paymentDate;
		this.paymentMethod = paymentMethod;
		this.amount = amount;
		this.status = status;
		this.booking = booking;
	}
	public Payment() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Payment [paymentId=" + paymentId + ", paymentDate=" + paymentDate + ", paymentMethod=" + paymentMethod
				+ ", amount=" + amount + ", status=" + status + ", booking=" + (booking != null ? booking.getBookingId() : "null") + "]";
	}
	
	
}
