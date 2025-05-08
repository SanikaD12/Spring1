package com.flight.serviceimpl;

import com.flight.entity.Flight;
import com.flight.service.FlightService;

import java.util.List;

import com.flight.Dao.FlightDao;
import com.flight.daoimp.FlightDaoImpl;

public class FlightServiceImpl implements FlightService{
	
	private FlightDao flightDAO;

    public FlightServiceImpl(FlightDao flightDAO) {
        this.flightDAO = flightDAO;
    }

    @Override
    public void addFlight(Flight flight) {
        // Business logic for flight validation, if needed
        flightDAO.saveFlight(flight);
    }

    @Override
    public Flight getFlightById(int id) {
        return flightDAO.getFlightById(id);
    }

    @Override
    public List<Flight> getAllFlights() {
        return flightDAO.getAllFlights();
    }

    @Override
    public List<Flight> searchFlights(String source, String destination) {
        return flightDAO.searchFlights(source, destination);
    }
    @Override
    public boolean deleteFlight(int flightId) {
        return flightDAO.deleteFlight(flightId);
    }

}
