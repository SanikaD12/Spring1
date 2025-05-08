package com.flight.serviceimpl;

import com.flight.Dao.*;
import com.flight.daoimp.*;
import com.flight.entity.Admin;
import com.flight.service.AdminService;
public class AdminServiceImpl implements AdminService {

	private AdminDao adminDAO = new AdminDaoImpl();

    
    public void addAdmin(Admin admin) {
        adminDAO.addAdmin(admin);
    }

   
    public Admin login(String email, String password) {
        return adminDAO.getAdminByEmailAndPassword(email, password);
    }
}
