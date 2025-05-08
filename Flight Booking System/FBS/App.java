package com.flight.Flightbookingsystem;




import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.flight.daoimp.*;
import com.flight.entity.*;
import com.flight.Flightbookingsystem.AllOperations;
import com.flight.service.*;
import com.flight.serviceimpl.*;




/**
 * Hello world!
 */
public class App {
   

		public static void main(String[] args) {
	        // Add default admin if not already added
			
			Logger hibernateLogger = Logger.getLogger("org.hibernate");
	        hibernateLogger.setLevel(Level.SEVERE); 
	        Admin defaultAdmin = new Admin(001, "Admin", "flightadmin@gmail.com", "admin123");
	        AdminService adminService = new AdminServiceImpl();

	        if (adminService.login("flightadmin@gmail.com", "admin123") == null) {
	            adminService.addAdmin(defaultAdmin);
	        }

	        // ✅ Create an instance of AllOperations
	        AllOperations operations = new AllOperations();
	        operations.start(); // This method already handles main menu loop
	    }
}
