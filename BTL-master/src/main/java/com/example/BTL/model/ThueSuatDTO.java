package com.example.BTL.model;

public class ThueSuatDTO {
	private int id;
	private int  bacthue;
	private double luongmin;
	private double luongmax;
	private int phantramthue;
	private double tiengiamTU;
	private String luongMin;
	private String luongMax;
	private int id_mast;
	
	
	
	public int getId_mast() {
		return id_mast;
	}
	public void setId_mast(int id_mast) {
		this.id_mast = id_mast;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLuongMin() {
		return luongMin;
	}
	public void setLuongMin(String luongMin) {
		this.luongMin = luongMin;
	}
	public String getLuongMax() {
		return luongMax;
	}
	public void setLuongMax(String luongMax) {
		this.luongMax = luongMax;
	}
	public int getBacthue() {
		return bacthue;
	}
	public void setBacthue(int bacthue) {
		this.bacthue = bacthue;
	}
	public double getLuongmin() {
		return luongmin;
	}
	public void setLuongmin(double luongmin) {
		this.luongmin = luongmin;
	}
	public double getLuongmax() {
		return luongmax;
	}
	public void setLuongmax(double luongmax) {
		this.luongmax = luongmax;
	}
	public int getPhantramthue() {
		return phantramthue;
	}
	public void setPhantramthue(int phantramthue) {
		this.phantramthue = phantramthue;
	}
	public double getTiengiamTU() {
		return tiengiamTU;
	}
	public void setTiengiamTU(double tiengiamTU) {
		this.tiengiamTU = tiengiamTU;
	}
	public ThueSuatDTO() {
		super();
	}
	
	
}
