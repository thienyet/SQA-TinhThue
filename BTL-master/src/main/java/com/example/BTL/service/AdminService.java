package com.example.BTL.service;

import java.util.List;

import com.example.BTL.model.AdminDTO;

public interface AdminService {
	public void createAdmin(AdminDTO admin);
	public void deleteAdmin(int id);
	public void editAdmin(AdminDTO admin);
	public AdminDTO loginAdmin(String username);
	public List<AdminDTO> getListPerson();
	public AdminDTO getAdminByID(int id);
}
