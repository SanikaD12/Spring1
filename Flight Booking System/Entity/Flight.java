package com.flight.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
//@GeneratedValue(strategy = GenerationType.IDENTITY)
public class Flight {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Flight_ID")
    private int flightId;

    @Column(name = "Airline_Name")
    private String airlineName;

    @Column(name = "Source")
    private String source;

    @Column(name = "Destination")
    private String destination;

    @Column(name = "Departure_Time")
    private String departureTime;

    @Column(name = "Arrival_Time")
    private String arrivalTime;

    @Column(name = "Total_Seats")
    private int totalSeats;

    @Column(name = "Available_Seats")
    private int availableSeats;

    @Column(name = "Price")
    private double price;

    @Column(name = "Gate_Number")
    private String gateNumber;

    @ManyToOne
    @JoinColumn(name = "airport_id")
    private Airport airport;

    public int getFlightId() {
        return flightId;
    }

    public void setFlightId(int flightId) {
        this.flightId = flightId;
    }

    public String getAirlineName() {
        return airlineName;
    }

    public void setAirlineName(String airlineName) {
        this.airlineName = airlineName;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public int getTotalSeats() {
        return totalSeats;
    }

    public void setTotalSeats(int totalSeats) {
        this.totalSeats = totalSeats;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getGateNumber() {
        return gateNumber;
    }

    public void setGateNumber(String gateNumber) {
        this.gateNumber = gateNumber;
    }

    public Airport getAirport() {
        return airport;
    }

    public void setAirport(Airport airport) {
        this.airport = airport;
    }

    public Flight(String airlineName, String source, String destination, String departureTime,
                  String arrivalTime, int totalSeats, int availableSeats, double price, String gateNumber, Airport airport) {
        this.airlineName = airlineName;
        this.source = source;
        this.destination = destination;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.totalSeats = totalSeats;
        this.availableSeats = availableSeats;
        this.price = price;
        this.gateNumber = gateNumber;
        this.airport = airport;
    }

    public Flight(String source, String destination, String departureTime, int totalSeats,
                  int availableSeats, double price, String airlineName, String gateNumber, Airport airport) {
        this.source = source;
        this.destination = destination;
        this.departureTime = departureTime;
        this.totalSeats = totalSeats;
        this.availableSeats = availableSeats;
        this.price = price;
        this.airlineName = airlineName;
        this.gateNumber = gateNumber;
        this.airport = airport;
    }

    public Flight() {
    }

    @Override
    public String toString() {
        return "Flight [flightId=" + flightId + ", airlineName=" + airlineName + ", source=" + source
                + ", destination=" + destination + ", departureTime=" + departureTime + ", arrivalTime="
                + arrivalTime + ", totalSeats=" + totalSeats + ", availableSeats=" + availableSeats
                + ", price=" + price + ", gateNumber=" + gateNumber + ", airport="
                + (airport != null ? airport.getAirportId() : "null") + "]";
    }

}
