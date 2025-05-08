package com.flight.serviceimpl;

import com.flight.entity.Booking;
import com.flight.service.BookingService;

import java.util.List;

import com.flight.Dao.BookingDao;
import com.flight.daoimp.BookingDaoImpl;

public class BookingServiceImpl implements BookingService {
	
	private BookingDao bookingDAO;

    public BookingServiceImpl(BookingDao bookingDAO) {
        this.bookingDAO = bookingDAO;
    }

    @Override
    public void createBooking(Booking booking) {
        // Business logic for booking validation, such as checking seat availability
        bookingDAO.saveBooking(booking);
    }

    @Override
    public Booking getBookingById(int id) {
        return bookingDAO.getBookingById(id);
    }

    @Override
    public List<Booking> getBookingsByPassengerId(int passengerId) {
        return bookingDAO.getBookingsByPassengerId(passengerId);
    }

    @Override
    public void cancelBooking(int bookingId) {
        // Additional logic for cancellation, if required
        bookingDAO.cancelBooking(bookingId);
    }

    @Override
    public List<Booking> getAllBookings() {
        return bookingDAO.getAllBookings();
    }
    @Override
    public void updateBooking(Booking booking) {
        bookingDAO.updateBooking(booking); // Delegate to DAO
    }

}
