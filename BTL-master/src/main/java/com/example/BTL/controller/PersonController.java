package com.example.BTL.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.BTL.model.AdminDTO;
import com.example.BTL.service.AdminService;

@Controller
@RequestMapping("/admin")
public class PersonController {
	
	@Autowired
	private AdminService adminService;
	
	@GetMapping("/addPerson")
	public String getAddPerson(Model model) {
		AdminDTO adminDTO= new AdminDTO();
		model.addAttribute("adminDTO", adminDTO);
		return "/person/addPerson";
	}
	
	@PostMapping("/addPerson")
	public String postAddPerson(@ModelAttribute(name="adminDTO") AdminDTO adminDTO) {
		
		adminService.createAdmin(adminDTO);
		return "redirect:/admin/listPerson";
	}
	
	@GetMapping("/listPerson")
	public String getListPerson(Model model) {
		List<AdminDTO> list = adminService.getListPerson();
		if(list!=null) {
			model.addAttribute("list", list);
			
		}
		else {
			model.addAttribute("empty","Danh sách trống ");
		}
		return "/person/listPerson";
	}
	
	@GetMapping("/deletePerson")
	public String deletePerson(@RequestParam(name="id") String id) {
		if(id!=null) {
			adminService.deleteAdmin(Integer.parseInt(id));
		}
		return "redirect:/admin/listPerson";
	}
	

	@GetMapping("/editPerson")
	public String getEditPerson(Model model,
			@RequestParam(name="id") String id) {
		AdminDTO adminDTO = new AdminDTO();
		if(id!=null) {
			adminDTO= adminService.getAdminByID(Integer.parseInt(id));
		}
		model.addAttribute("adminDTO", adminDTO);
		
		return "person/editPerson";
	}
	
	@PostMapping("/editPerson")
	public String postEditPerson(@ModelAttribute(name="adminDTO") AdminDTO adminDTO) {
		if(adminDTO!=null) {
			adminService.editAdmin(adminDTO);
		}
		return "redirect:/admin/listPerson";
	}
}
