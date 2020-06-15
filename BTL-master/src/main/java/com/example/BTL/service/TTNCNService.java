package com.example.BTL.service;

import java.util.List;

import com.example.BTL.model.TTNCNDTO;

public interface TTNCNService {
	public List<TTNCNDTO> getListTTNCN();
	public void add(TTNCNDTO t);
	public void delete(int id);
	public void update(TTNCNDTO t);
	public TTNCNDTO getById(int id);
}
