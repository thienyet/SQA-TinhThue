package com.example.BTL.model;

import java.io.Serializable;

public class KhoanGiamTruDTO implements Serializable{
	private String mast;
	private double gtbanthan;
	private double gtnguoiphuthuoc;
	private double gtbaohiem;
	private double tonggia;
	public KhoanGiamTruDTO() {
		super();
	}
	public String getMast() {
		return mast;
	}
	public void setMast(String mast) {
		this.mast = mast;
	}
	public double getGtbanthan() {
		return gtbanthan;
	}
	public void setGtbanthan(double gtbanthan) {
		this.gtbanthan = gtbanthan;
	}
	public double getGtnguoiphuthuoc() {
		return gtnguoiphuthuoc;
	}
	public void setGtnguoiphuthuoc(double gtnguoiphuthuoc) {
		this.gtnguoiphuthuoc = gtnguoiphuthuoc;
	}
	public double getGtbaohiem() {
		return gtbaohiem;
	}
	public void setGtbaohiem(double gtbaohiem) {
		this.gtbaohiem = gtbaohiem;
	}
	public double getTonggia() {
		return tonggia;
	}
	public void setTonggia(double tonggia) {
		this.tonggia = tonggia;
	}
	
}
