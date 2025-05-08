package com.flight.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;



@Entity
public class Admin {

	@Id
	@Column(name="Admin_ID")
	@NotNull(message = "Invalid ID. Please enter your ID.")
	private int adminId;
	
	@Column(name="Name",length = 30,nullable = false)
	private String name;
	
	@Column(name="Email" ,length=30)
	@Email(message = "Invalid email address. Please enter a proper email ID.")
    @NotEmpty(message = "Please enter your email ID.")
	private String email;
	
	@Column(name="Password" ,length=10)
	private String password;

	public int getAdminId() {
		return adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Admin(int adminId, String name, String email, String password) {
		super();
		this.adminId = adminId;
		this.name = name;
		this.email = email;
		this.password = password;
	}

	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Admin [adminId=" + adminId + ", name=" + name + ", email=" + email + ", password=" + password + "]";
	}
	
	

	
	
	
	
	
}
