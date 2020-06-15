package com.example.BTL.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="khoanmienthue")
public class KhoanMienThue {
	@Id
	private String mast;
	private double tienan;
	private double tiendt;
	private double tientp;
	private double tiendc;
	private double tienkhac;
	private double tongmien;
	public KhoanMienThue() {
		super();
	}
	public String getMast() {
		return mast;
	}
	public void setMast(String mast) {
		this.mast = mast;
	}
	public double getTienan() {
		return tienan;
	}
	public void setTienan(double tienan) {
		this.tienan = tienan;
	}
	public double getTiendt() {
		return tiendt;
	}
	public void setTiendt(double tiendt) {
		this.tiendt = tiendt;
	}
	public double getTientp() {
		return tientp;
	}
	public void setTientp(double tientp) {
		this.tientp = tientp;
	}
	public double getTiendc() {
		return tiendc;
	}
	public void setTiendc(double tiendc) {
		this.tiendc = tiendc;
	}
	public double getTienkhac() {
		return tienkhac;
	}
	public void setTienkhac(double tienkhac) {
		this.tienkhac = tienkhac;
	}
	public double getTongmien() {
		return tongmien;
	}
	public void setTongmien(double tongmien) {
		this.tongmien = tongmien;
	}
	
}
