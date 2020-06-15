package com.example.BTL.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="admin")
public class Admin {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int adminid;
	
	@Column(name="username")
	private String username;
	
	@Column(name="password")
	private String password;

	@Column(name="role")
	private String role;
	
	public Admin() {
		super();
	}
	
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public int getAdminid() {
		return adminid;
	}

	public void setAdminid(int adminid) {
		this.adminid = adminid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	

}
