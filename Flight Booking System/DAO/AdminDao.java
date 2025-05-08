package com.flight.Dao;

import com.flight.entity.Admin;

public interface AdminDao {

	void addAdmin(Admin admin);
    Admin getAdminByEmailAndPassword(String email, String password);
}
