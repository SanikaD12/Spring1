package com.flight.service;

import java.util.List;

import com.flight.entity.Flight;

public interface FlightService {

	void addFlight(Flight flight);
    Flight getFlightById(int id);
    List<Flight> getAllFlights();
    List<Flight> searchFlights(String source, String destination);
    boolean deleteFlight(int flightId);

}

