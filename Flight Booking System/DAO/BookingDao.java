package com.flight.Dao;

import java.util.List;

import com.flight.entity.Booking;

public interface BookingDao {
	
	 void saveBooking(Booking booking);
	    Booking getBookingById(int id);
	    List<Booking> getBookingsByPassengerId(int passengerId);
	    void cancelBooking(int bookingId);
	    List<Booking> getAllBookings();
	    void updateBooking(Booking booking);


}
