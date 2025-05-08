package com.flight.Dao;

import java.util.List;

import com.flight.entity.Airport;

public interface AirportDao {
	
	void saveAirport(Airport airport);
    List<Airport> getAllAirports();
    Airport getAirportById(int id);
    boolean deleteAirport(int airportId);

	

}
