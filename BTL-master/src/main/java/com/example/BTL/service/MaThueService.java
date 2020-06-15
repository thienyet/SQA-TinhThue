package com.example.BTL.service;

import java.util.List;

import com.example.BTL.model.MaThueDTO;

public interface MaThueService {
	public List<MaThueDTO> getListMT();
	public void createMT(MaThueDTO m);
	public void delete(int id);
	public void update(MaThueDTO m);
	public MaThueDTO getById(int id);
}
