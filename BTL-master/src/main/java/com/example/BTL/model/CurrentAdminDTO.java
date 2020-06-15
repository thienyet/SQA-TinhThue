package com.example.BTL.model;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

public class CurrentAdminDTO extends User{
	
	private static final long serialVersionUID = 1L;
	private int id;
	private String role;
	
	
	

	public CurrentAdminDTO(String username, String password,
			Collection<? extends GrantedAuthority> authorities) {
		super(username, password,authorities);
		// TODO Auto-generated constructor stub
	}




	public int getId() {
		return id;
	}




	public void setId(int id) {
		this.id = id;
	}




	public String getRole() {
		return role;
	}




	public void setRole(String role) {
		this.role = role;
	}

	/**
	 * 
	 */
	

}
