package com.example.BTL.dao;

import java.util.List;

import com.example.BTL.entity.Admin;

public interface AdminDao {
	public void createAdmin(Admin admin);
	public void deleteAdmin(Admin admin);
	public void editAdmin(Admin admin);
	public Admin loginAdmin(String username);
	public Admin getAdminByID(int id);
	public List<Admin> getListPerson();
}
