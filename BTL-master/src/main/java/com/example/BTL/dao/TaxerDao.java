package com.example.BTL.dao;

import java.util.List;

import com.example.BTL.entity.Taxer;

public interface TaxerDao {
	public List<Taxer> getListTaxer();
	public Taxer getTaxerById(int id);
}
