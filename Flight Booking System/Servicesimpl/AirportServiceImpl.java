package com.flight.serviceimpl;

import com.flight.entity.Airport;
import com.flight.service.AirportService;

import java.util.List;

import com.flight.Dao.AirportDao;
import com.flight.daoimp.AirportDaoImpl;

public class AirportServiceImpl implements AirportService {
	
	private AirportDao airportDAO;  // DAO for handling airport data

    // Constructor injection for DAO
    public AirportServiceImpl(AirportDao airportDAO) {
        this.airportDAO = airportDAO;
    }

    // Add a new airport
    @Override
    public void addAirport(Airport airport) {
        // Here you can include any business logic for airport validation if needed
        airportDAO.saveAirport(airport);  // Delegate to DAO to save the airport
    }

    // Retrieve an airport by its ID
    @Override
    public Airport getAirportById(int id) {
        return airportDAO.getAirportById(id);  // Delegate to DAO to get airport by ID
    }

    // Retrieve all airports
    @Override
    public List<Airport> getAllAirports() {
        return airportDAO.getAllAirports();  // Delegate to DAO to get all airports
    }
    @Override
    public boolean deleteAirport(int airportId) {
        return airportDAO.deleteAirport(airportId);
    }

}
