package com.example.BTL.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.BTL.dao.AdminDao;
import com.example.BTL.entity.Admin;
import com.example.BTL.model.AdminDTO;
import com.example.BTL.model.CurrentAdminDTO;
import com.example.BTL.service.AdminService;

@Service
@Transactional
public class AdminServiceImpl implements AdminService,UserDetailsService{

	@Autowired
	private AdminDao adminDao;

	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Override
	public void createAdmin(AdminDTO admin) {
		// TODO Auto-generated method stub
		Admin a = new Admin();
		a.setUsername(admin.getUsername());
		a.setPassword(passwordEncoder.encode(admin.getPassword()));
		a.setRole(admin.getRole());
		
		adminDao.createAdmin(a);
		
	}

	@Override
	public void deleteAdmin(int id) {
		// TODO Auto-generated method stub
		Admin admin = adminDao.getAdminByID(id);
		if(admin!=null) {
			adminDao.deleteAdmin(admin);

		}
	}

	@Override
	public void editAdmin(AdminDTO admin) {
		// TODO Auto-generated method stub
		Admin a = new Admin();
		a.setAdminid(admin.getId());
		a.setUsername(admin.getUsername());
		a.setRole(admin.getRole());
		adminDao.editAdmin(a);
		
	}

	@Override
	public AdminDTO loginAdmin(String username) {
		// TODO Auto-generated method stub
		Admin admin = adminDao.loginAdmin(username);
		
		AdminDTO adminDTO = new AdminDTO();
		adminDTO.setId(admin.getAdminid());
		adminDTO.setUsername(admin.getUsername());
		adminDTO.setPassword(admin.getPassword());
		
		return adminDTO;
	}

	@Override
	public List<AdminDTO> getListPerson() {
		// TODO Auto-generated method stub
		List<AdminDTO> listAdminDTOs = new ArrayList<AdminDTO>();
		List<Admin> listAdmin = adminDao.getListPerson();
		for(Admin admin: listAdmin) {
			AdminDTO adminDTO = new AdminDTO();
			adminDTO.setId(admin.getAdminid());
			adminDTO.setUsername(admin.getUsername());
			adminDTO.setPassword(admin.getPassword());
			listAdminDTOs.add(adminDTO);
		}
		return listAdminDTOs;
	}

	@Override
	public AdminDTO getAdminByID(int id) {
		// TODO Auto-generated method stub
		AdminDTO adminDTO = new AdminDTO();
		Admin admin = adminDao.getAdminByID(id);
		adminDTO.setId(admin.getAdminid());
		adminDTO.setUsername(admin.getUsername());
		adminDTO.setPassword(admin.getPassword());
		adminDTO.setRole(admin.getRole());
		return adminDTO;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Admin user = adminDao.loginAdmin(username);
		if(user==null) {
			throw new UsernameNotFoundException("not found");
		}
//		SimpleGrantedAuthority authority=new SimpleGrantedAuthority(user.getRole());
//		
//		List<SimpleGrantedAuthority> authorities=new ArrayList<SimpleGrantedAuthority>();
//		authorities.add(authority);
//		
//		CurrentUserDTO currentUser=new CurrentUserDTO(username, user.getPassword(), authorities);
//		currentUser.setId(user.getId());
//		currentUser.setName(user.getName());
//		currentUser.setRole(user.getRole());
		Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        grantedAuthorities.add(new SimpleGrantedAuthority(user.getRole()));
        CurrentAdminDTO currentAdminDTO=new CurrentAdminDTO(username, user.getPassword(), grantedAuthorities);
		currentAdminDTO.setId(user.getAdminid());
		currentAdminDTO.setRole(user.getRole());
		return currentAdminDTO;
	}

}
