package com.example.BTL.service;

import java.util.List;

import com.example.BTL.entity.Taxer;
import com.example.BTL.model.TaxerDTO;

public interface TaxerService {
	public List<TaxerDTO> getListTaxer();
	public TaxerDTO getTaxerById(int id);
}
