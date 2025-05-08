package com.flight.serviceimpl;

import com.flight.entity.Passenger;
import com.flight.service.PassengerService;

import java.util.List;

import com.flight.Dao.PassengerDao;
import com.flight.daoimp.PassengerDaoImpl;

public class PassengerServiceImpl implements PassengerService {
	
	private PassengerDao passengerDAO;

    public PassengerServiceImpl(PassengerDao passengerDAO) {
        this.passengerDAO = passengerDAO;
    }

    @Override
    public void registerPassenger(Passenger passenger) {
        // Business logic, for example, validating the passenger data
        if (passenger.getEmail() == null || passenger.getEmail().isEmpty()) {
            throw new IllegalArgumentException("Email is required");
        }
        // Save passenger via DAO
        passengerDAO.savePassenger(passenger);
    }

    @Override
    public Passenger getPassengerById(int id) {
        return passengerDAO.getPassengerById(id);
    }

    @Override
    public Passenger getPassengerByEmail(String email) {
        return passengerDAO.getPassengerByEmail(email);
    }

    @Override
    public List<Passenger> getAllPassengers() {
        return passengerDAO.getAllPassengers();
    }
    

}
