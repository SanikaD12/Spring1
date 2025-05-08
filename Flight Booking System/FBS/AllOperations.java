package com.flight.Flightbookingsystem;

import java.util.Scanner;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import com.flight.daoimp.*;
import com.flight.entity.*;
import com.flight.serviceimpl.*;

public class AllOperations {

	Scanner sc = new Scanner(System.in);

	PassengerServiceImpl passengerService = new PassengerServiceImpl(new PassengerDaoImpl());
	FlightServiceImpl flightService = new FlightServiceImpl(new FlightDaoImpl());
	BookingServiceImpl bookingService = new BookingServiceImpl(new BookingDaoImpl());
	PaymentServiceImpl paymentService = new PaymentServiceImpl(new PaymentDaoImpl());
	AirportServiceImpl airportService = new AirportServiceImpl(new AirportDaoImpl());

	final String ADMIN_EMAIL = "flightadmin@gmail.com";
	final String ADMIN_PASS = "admin123";

	public void start() {
		System.out.println("\n===== Welcome to Flight Booking System =====");

		while (true) {
			System.out.println("\nMain Menu:");
			System.out.println("1. Admin Login");
			System.out.println("2. Passenger Registration");
			System.out.println("3. Passenger Login");
			System.out.println("4. Exit");
			System.out.print("Choose an option: ");
			int choice = sc.nextInt();

			switch (choice) {
			case 1 -> adminLogin();
			case 2 -> registerPassenger();
			case 3 -> passengerLogin();
			case 4 -> {
				System.out.println("Thank you for using the system. Goodbye!");
				System.exit(0);
			}
			default -> System.out.println("Invalid choice. Try again.");
			}
		}
	}

	public void adminLogin() {
		System.out.print("Enter Admin Email: ");
		String email = sc.next();
		System.out.print("Enter Admin Password: ");
		String password = sc.next();

		if (ADMIN_EMAIL.equals(email) && ADMIN_PASS.equals(password)) {
			System.out.println("\nAdmin login successful!");
			adminMenu();
		} else {
			System.out.println("Invalid admin credentials.");
		}
	}

	public void adminMenu() {
		while (true) {
			System.out.println("\nAdmin Menu:");
			System.out.println("1. Add Flight");
			System.out.println("2. View Flights");
			System.out.println("3. View Bookings"); 
			System.out.println("4. View Passengers");
			System.out.println("5. Add Airport");
			System.out.println("6. View Airports");
			System.out.println("7. Delete Flight");
			System.out.println("8. Delete Airport");
			System.out.println("9. Logout");
			System.out.print("Choose an option: ");

			while (!sc.hasNextInt()) {
				System.out.println("Please enter a valid option number.");
				sc.next(); // discard invalid input
			}
			int choice = sc.nextInt();
			sc.nextLine(); // clear buffer

			switch (choice) {
			case 1 -> {
				System.out.print("Source: ");
				String source = sc.nextLine();

				System.out.print("Destination: ");
				String dest = sc.nextLine();

				System.out.print("Departure Time: ");
				String time = sc.nextLine();

				System.out.print("Arrival Time: ");
				String arrivalTime = sc.nextLine();

				System.out.print("Total Seats: ");
				while (!sc.hasNextInt()) {
					System.out.println("Please enter a valid number.");
					sc.next();
				}
				int seats = sc.nextInt();
				sc.nextLine();

				System.out.print("Price per Seat: ");
				while (!sc.hasNextDouble()) {
					System.out.println("Please enter a valid price.");
					sc.next();
				}
				double price = sc.nextDouble();
				sc.nextLine();

				System.out.println("Airline Name:");
				String airline = sc.nextLine();

				System.out.print("Gate Number: ");
				String gateNumber = sc.nextLine();

				// Link Airport
				List<Airport> airports = airportService.getAllAirports();
				if (airports != null && !airports.isEmpty()) {
				    airports.forEach(System.out::println);
				} else {
				    System.out.println("No airports found.");
				}

				System.out.print("Enter Airport ID to link with this flight: ");
				int airportId = sc.nextInt();
				sc.nextLine();

				Airport selectedAirport = airportService.getAirportById(airportId);
				if (selectedAirport == null) {
					System.out.println("Invalid Airport ID. Flight not added.");
					break;
				}

				Flight flight = new Flight(airline, source, dest, time, arrivalTime, seats, seats, price, gateNumber,
						selectedAirport);
				flight.setAirport(selectedAirport);

				flightService.addFlight(flight);
				System.out.println("Flight added successfully with Gate Number: " + gateNumber
						+ " and linked to Airport: " + selectedAirport.getName());
			}
			case 2 -> flightService.getAllFlights().forEach(System.out::println);
			case 3 -> bookingService.getAllBookings().forEach(System.out::println);
			case 4 -> passengerService.getAllPassengers().forEach(System.out::println);
			case 5 -> {
				System.out.print("Airport Name: ");
				String name = sc.nextLine();
				System.out.print("Code: ");
				String code = sc.nextLine();
				System.out.print("Location: ");
				String location = sc.nextLine();
				Airport airport = new Airport(name, code, location);
				airportService.addAirport(airport);
				System.out.println("Airport added successfully.");
			}
			case 6 -> airportService.getAllAirports().forEach(System.out::println);
			case 7 -> {
				System.out.print("Enter Flight ID to delete: ");
				int flightId = sc.nextInt();
				sc.nextLine();
				boolean deleted = flightService.deleteFlight(flightId);
				if (deleted) {
					System.out.println("Flight deleted successfully.");
				} else {
					System.out.println("Flight not found or couldn't be deleted.");
				}
			}
			case 8 -> {
				System.out.print("Enter Airport ID to delete: ");
				int airportId = sc.nextInt();
				sc.nextLine();
				boolean deleted = airportService.deleteAirport(airportId);
				if (deleted) {
					System.out.println("Airport deleted successfully.");
				} else {
					System.out.println("Airport not found or couldn't be deleted.");
				}
			}
			case 9 -> {
				return;
			}
			default -> System.out.println("Invalid choice.");
			}
		}
	}

	public void registerPassenger() {
		System.out.print("Name: ");
		String name = sc.next();
		String phone;
	    while (true) {
	        System.out.print("Phone: ");
	        phone = sc.next();
	        if (phone.matches("\\d{10}")) {
	            break;
	        } else {
	            System.out.println("Invalid phone number! Please enter a 10-digit number.");
	        }
	    }

	    // Email validation
	    String email;
	    while (true) {
	        System.out.print("Email: ");
	        email = sc.next();
	        if (email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {
	            break;
	        } else {
	            System.out.println("Invalid email format! Please try again.");
	        }
	    }

		System.out.print("Password: ");
		String pass = sc.next();
		Passenger p = new Passenger(name, phone, email, pass);
		passengerService.registerPassenger(p);
		System.out.println("Passenger registered successfully!");
	}

	public void passengerLogin() {
		System.out.print("Email: ");
		String email = sc.next();
		System.out.print("Password: ");
		String pass = sc.next();

		Passenger p = passengerService.getPassengerByEmail(email);
		if (p != null && pass.equals(p.getPassword())) {
			System.out.println("\nWelcome, " + p.getName());
			System.out.println("Your Passenger ID is: " + p.getPassengerId());
			passengerMenu(p); // Pass the Passenger object to the menu
		} else {
			System.out.println("Invalid credentials.");
		}
	}

	private void passengerMenu(Passenger p) {
		while (true) {
			System.out.println("\nPassenger Menu:");
			System.out.println("1. Search Flights");
			System.out.println("2. Book Flight");
			System.out.println("3. View My Bookings");
			System.out.println("4. Cancel Booking");
			System.out.println("5. Logout");
			System.out.print("Choose an option: ");
			int choice = sc.nextInt();

			switch (choice) {
			case 1 -> {
				System.out.print("Enter Source: ");
				String src = sc.next();
				System.out.print("Enter Destination: ");
				String dest = sc.next();
				flightService.searchFlights(src, dest).forEach(System.out::println);
			}
			case 2 -> {
				flightService.getAllFlights().forEach(System.out::println);
                System.out.print("Enter Flight ID to book: ");
                int flightId = sc.nextInt();
                Flight flight = flightService.getFlightById(flightId);

                if (flight != null && flight.getAvailableSeats() > 0) {
                    System.out.print("Enter number of seats to book: ");
                    int seatCount = sc.nextInt();

                    if (seatCount <= flight.getAvailableSeats()) {
                        flight.setAvailableSeats(flight.getAvailableSeats() - seatCount);
                        flightService.addFlight(flight); // Update flight seats

                        // Create booking
                        Booking booking = new Booking();
                        booking.setPassenger(p); // ✅ Use current logged-in passenger
                        booking.setFlight(flight);
                        booking.setBookingDate(LocalDate.now());
                        booking.setStatus("Pending");
                        bookingService.createBooking(booking);

                        // Payment
                        double totalAmount = seatCount * flight.getPrice();
                        System.out.print("Enter Payment Method (Card/UPI): ");
                        String method = sc.next();

                        Payment payment = new Payment();
                        payment.setAmount(totalAmount);
                        payment.setBooking(booking);
                        payment.setPaymentDate(LocalDate.now());
                        payment.setPaymentMethod(method);
                        payment.setStatus("Successful");
                        paymentService.processPayment(payment);

                        // Finalize booking
                        booking.setPayment(payment);
                        booking.setStatus("Confirmed");
                        bookingService.updateBooking(booking);

                        // ✅ Show confirmation
                        System.out.println("Booking successful! Total paid: Rs. " + totalAmount);
                        System.out.println("Your Booking ID: " + booking.getBookingId());
                        System.out.println("Your flight is allocated at gate: " + flight.getGateNumber());
                    } else {
                        System.out.println("Not enough seats available.");
                    }
                } else {
                    System.out.println("Invalid flight or no seats available.");
                }
			}
			case 3 -> {
				List<Booking> bookings = bookingService.getBookingsByPassengerId(p.getPassengerId());
				if (bookings.isEmpty()) {
					System.out.println("No bookings found.");
				} else {
					for (Booking booking : bookings) {
						System.out.println(booking);
					}
				}
			}
			case 4 -> {
				System.out.print("Enter Booking ID to cancel: ");
				int bId = sc.nextInt();
				bookingService.cancelBooking(bId);
				System.out.println("Booking cancelled.");
			}
			case 5 -> {
				return;
			}
			default -> System.out.println("Invalid choice.");
			}
		}
	}
}
