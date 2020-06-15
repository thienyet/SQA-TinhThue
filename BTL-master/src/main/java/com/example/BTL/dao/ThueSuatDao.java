package com.example.BTL.dao;

import java.util.List;

import com.example.BTL.entity.ThueSuat;

public interface ThueSuatDao {
	public List<ThueSuat> getListThueSuat(int id);
	public void add(ThueSuat t);
	public void edit(ThueSuat t);
	public void delete(ThueSuat t);
	public ThueSuat getById(int id);
}
