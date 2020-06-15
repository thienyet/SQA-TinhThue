package com.example.BTL.dao;

import java.util.List;

import com.example.BTL.entity.MaThue;

public interface MaThueDao {
	public List<MaThue> getListMT();
	public void createMT(MaThue m);
	public void delete(MaThue m);
	public void update(MaThue m);
	public MaThue getById(int id);
}
