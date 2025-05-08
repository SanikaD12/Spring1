package com.flight.service;

import java.util.List;

import com.flight.entity.Booking;

public interface BookingService {
	
	void createBooking(Booking booking);
    Booking getBookingById(int id);
    List<Booking> getBookingsByPassengerId(int passengerId);
    void cancelBooking(int bookingId);
    List<Booking> getAllBookings();
    void updateBooking(Booking booking);


}
