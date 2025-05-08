package com.flight.service;

import com.flight.entity.Admin;

public interface AdminService {

	void addAdmin(Admin admin);
    Admin login(String email, String password);
}
