package com.example.BTL.dao;

import java.util.List;
import com.example.BTL.entity.TTNCN;

public interface TTNCNDao {
	public List<TTNCN> getListTTNCN();
	public void add(TTNCN t);
	public void delete(TTNCN t);
	public void update(TTNCN t);
	public TTNCN getById(int id);
}
