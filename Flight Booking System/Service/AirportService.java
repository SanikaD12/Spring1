package com.flight.service;

import java.util.List;

import com.flight.entity.Airport;

public interface AirportService {

	void addAirport(Airport airport);

    // Retrieves an airport by its ID
    Airport getAirportById(int id);

    // Retrieves a list of all airports
    List<Airport> getAllAirports();
    boolean deleteAirport(int airportId);

    
}
