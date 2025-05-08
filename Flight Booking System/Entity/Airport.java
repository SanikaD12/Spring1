package com.flight.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Airport {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Airport_ID")
	private int airportId;
	
	@Column(name="airport_name", nullable = false )
	private String name;
	
	@Column(name="Code")
	private String code;
	
	@Column(name="Location")
	private String location;

	public int getAirportId() {
		return airportId;
	}

	public void setAirportId(int airportId) {
		this.airportId = airportId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	
	

	public Airport(String name, String code, String location) {
		super();
		this.name = name;
		this.code = code;
		this.location = location;
	}

	public Airport() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Airport [airportId=" + airportId + ", name=" + name + ", code=" + code + ", location=" + location + "]";
	}
	
	
}
