package com.example.BTL.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ManyToAny;

@Entity
@Table(name="thuesuat")
public class ThueSuat {
	
	@Id
	private int id;
	
	@ManyToOne
	@JoinColumn(name="id_mast")
	private MaThue maThue;
	
	private int  bacthue;
	private double luongmin;
	private double luongmax;
	private int phantramthue;
	private double tiengiamTU;
	public ThueSuat() {
		super();
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	

	public MaThue getMaThue() {
		return maThue;
	}

	public void setMaThue(MaThue maThue) {
		this.maThue = maThue;
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
	
	
	
}
