package com.flight.entity;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Passenger {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Passenger_ID")
    private int passengerId;

    @Column(name = "Name")
    private String name;

    @Column(name = "Email")
    private String email;

    @Column(name = "Phone_Number")
    private String phoneNumber;

    
    
    @Column(name = "Password") // ✅ Add password column
    private String password;

    public Passenger() {
        // No-arg constructor required by JPA
    }
    public Passenger(String name, String phoneNumber, String email,  String password) {
         // auto-generating ID
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        
        this.password = password;
        
    }

    // Getters and Setters
    public  int getPassengerId() {
        return passengerId;
    }

    public void setPassengerId(int passengerId) {
        this.passengerId = passengerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // toString()
    @Override
    public String toString() {
        return "Passenger [passengerId=" + passengerId + ", name=" + name + ", email=" + email + ", phoneNumber="
                + phoneNumber +  ", password=" + password + "]";
    }
}
