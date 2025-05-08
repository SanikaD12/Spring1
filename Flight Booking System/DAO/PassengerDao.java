package com.flight.Dao;

import java.util.List;

import com.flight.entity.Passenger;

public interface PassengerDao {
	
	void savePassenger(Passenger passenger);
    Passenger getPassengerById(int id);
    
    Passenger getPassengerByEmail(String email);
    List<Passenger> getAllPassengers();

}
