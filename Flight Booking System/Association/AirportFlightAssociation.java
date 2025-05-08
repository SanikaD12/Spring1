package com.flight.association;

import com.flight.entity.Airport;
import com.flight.entity.Flight;

public class AirportFlightAssociation {
	
	 private Airport airport;
	    private Flight flight;

	    public AirportFlightAssociation(Airport airport, Flight flight) {
	        this.airport = airport;
	        this.flight = flight;
	    }

	    public Airport getAirport() {
	        return airport;
	    }

	    public void setAirport(Airport airport) {
	        this.airport = airport;
	    }

	    public Flight getFlight() {
	        return flight;
	    }

	    public void setFlight(Flight flight) {
	        this.flight = flight;
	    }

	    @Override
	    public String toString() {
	        return "AirportFlightAssociation{" +
	                "airport=" + airport +
	                ", flight=" + flight +
	                '}';
	    }

}
