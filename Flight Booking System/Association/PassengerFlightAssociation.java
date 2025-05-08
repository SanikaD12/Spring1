package com.flight.association;

import com.flight.entity.Flight;
import com.flight.entity.Passenger;

public class PassengerFlightAssociation {
	private Passenger passenger;
    private Flight flight;

    public PassengerFlightAssociation(Passenger passenger, Flight flight) {
        this.passenger = passenger;
        this.flight = flight;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    @Override
    public String toString() {
        return "PassengerFlightAssociation{" +
                "passenger=" + passenger +
                ", flight=" + flight +
                '}';
    }

}
