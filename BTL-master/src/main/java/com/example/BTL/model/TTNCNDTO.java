package com.example.BTL.model;

import java.io.Serializable;
import java.util.Date;

public class TTNCNDTO implements Serializable{
	private int id;
	private MaThueDTO mathue;
	private TaxerDTO taxerDTO;
	private String name;
	private String birdth;
	private String address;
	private String card;
	private double tongthunhap;
	private double thunhaptinhthue;
	private double thuetncn;
	private int status;
	private String tongthuNhap;
	private String thunhaptinhThue;
	private String thueTNCN;
	
	
	
	public TaxerDTO getTaxerDTO() {
		return taxerDTO;
	}

	public void setTaxerDTO(TaxerDTO taxerDTO) {
		this.taxerDTO = taxerDTO;
	}

	public String getTongthuNhap() {
		return tongthuNhap;
	}

	public void setTongthuNhap(String tongthuNhap) {
		this.tongthuNhap = tongthuNhap;
	}

	public String getThunhaptinhThue() {
		return thunhaptinhThue;
	}

	public void setThunhaptinhThue(String thunhaptinhThue) {
		this.thunhaptinhThue = thunhaptinhThue;
	}

	public String getThueTNCN() {
		return thueTNCN;
	}

	public void setThueTNCN(String thueTNCN) {
		this.thueTNCN = thueTNCN;
	}

	public TTNCNDTO() {
		super();
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
	public MaThueDTO getMathue() {
		return mathue;
	}

	public void setMathue(MaThueDTO mathue) {
		this.mathue = mathue;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBirdth() {
		return birdth;
	}
	public void setBirdth(String birdth) {
		this.birdth = birdth;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCard() {
		return card;
	}
	public void setCard(String card) {
		this.card = card;
	}
	public double getTongthunhap() {
		return tongthunhap;
	}
	public void setTongthunhap(double tongthunhap) {
		this.tongthunhap = tongthunhap;
	}
	public double getThunhaptinhthue() {
		return thunhaptinhthue;
	}
	public void setThunhaptinhthue(double thunhaptinhthue) {
		this.thunhaptinhthue = thunhaptinhthue;
	}
	public double getThuetncn() {
		return thuetncn;
	}
	public void setThuetncn(double thuetncn) {
		this.thuetncn = thuetncn;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	
}
