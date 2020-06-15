package com.example.BTL.model;

import java.io.Serializable;

public class TaxerDTO implements Serializable{

	private int id;
	private String name;
	private String description;
	private float thuesuat;
	
	
	public TaxerDTO() {
		super();
	}
	
	public float getThuesuat() {
		return thuesuat;
	}

	public void setThuesuat(float thuesuat) {
		this.thuesuat = thuesuat;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
