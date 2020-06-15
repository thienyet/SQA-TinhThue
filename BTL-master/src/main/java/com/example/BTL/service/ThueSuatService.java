package com.example.BTL.service;

import java.util.List;

import com.example.BTL.model.ThueSuatDTO;

public interface ThueSuatService {
	public List<ThueSuatDTO> getListThueSuat(int id);
	public void add(ThueSuatDTO t);
	public void edit(ThueSuatDTO t);
	public void delete(int id);
	public ThueSuatDTO getById(int id);
}
