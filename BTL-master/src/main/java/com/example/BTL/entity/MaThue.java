package com.example.BTL.entity;

import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="mathue")
public class MaThue {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String maST;
	private Date startDate;
	private Date endDate;
	@OneToMany(mappedBy = "maThue" , fetch = FetchType.LAZY, cascade = CascadeType.ALL ,orphanRemoval = true)
	private List<ThueSuat> listTS;
	
	@OneToMany(mappedBy = "maThue" , fetch = FetchType.LAZY, cascade = CascadeType.ALL ,orphanRemoval = true)
	private List<TTNCN> listTtncns;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMaST() {
		return maST;
	}
	public void setMaST(String maST) {
		this.maST = maST;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
	public List<ThueSuat> getListTS() {
		return listTS;
	}
	public void setListTS(List<ThueSuat> listTS) {
		this.listTS = listTS;
	}
	
	public List<TTNCN> getListTtncns() {
		return listTtncns;
	}
	public void setListTtncns(List<TTNCN> listTtncns) {
		this.listTtncns = listTtncns;
	}
	public MaThue() {
		super();
	}
	
	
	
}
