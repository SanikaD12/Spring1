package com.flight.service;

import java.util.List;

import com.flight.entity.Passenger;

public interface PassengerService {
	
	void registerPassenger(Passenger passenger);
    Passenger getPassengerById(int id);
    Passenger getPassengerByEmail(String email);
    List<Passenger> getAllPassengers();

}
