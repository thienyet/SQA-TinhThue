package com.example.BTL.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.BTL.model.AdminDTO;
import com.example.BTL.service.AdminService;

@Controller
public class LoginController {
	@Autowired
	AdminService adminService;
	
	@GetMapping("/loginAdmin")
	public String login(Model model,
			@RequestParam(name="err", required = false) String err) {
		AdminDTO adminDTO = new AdminDTO();
		model.addAttribute("adminDTO",adminDTO);
		if(err !=null) {
			model.addAttribute("error", "Loi dang nhap");
		}
		return "/login";
	}
	
	@PostMapping("/loginAdmin")
	public String login_process(@ModelAttribute(name="adminDTO") AdminDTO adminDTO) {
		AdminDTO admin = adminService.loginAdmin(adminDTO.getUsername());
		if(adminDTO.getPassword().equals(admin.getPassword())) {
			return "redirect:/admin/welcome";
		}
		return "redirect:/loginAdmin?err=1";
	}
	
	@GetMapping("/access-denied")
	public String accessDeny() {
		return "/accessDeny";
	}
	
}
