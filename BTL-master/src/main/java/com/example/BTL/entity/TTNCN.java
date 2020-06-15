package com.example.BTL.entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="ttncn")
public class TTNCN {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	@JoinColumn(name="id_mast")
	private MaThue maThue;
	
	@ManyToOne
	@JoinColumn(name="idtaxer")
	private Taxer taxer;
	
	private String name;
	private Date birdth;
	private String address;
	private String card;
	private double tongthunhap;
	private double thunhaptinhthue;
	private double thuetncn;
	private int status;
	public TTNCN() {
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
	
	public Taxer getTaxer() {
		return taxer;
	}
	public void setTaxer(Taxer taxer) {
		this.taxer = taxer;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getBirdth() {
		return birdth;
	}
	public void setBirdth(Date birdth) {
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
