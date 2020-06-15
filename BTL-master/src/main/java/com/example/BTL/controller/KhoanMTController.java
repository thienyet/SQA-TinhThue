package com.example.BTL.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.BTL.model.KhoanMienThueDTO;
import com.example.BTL.service.KhoanMTService;

@Controller
@RequestMapping("/admin")
public class KhoanMTController {
	
	@Autowired 
	private KhoanMTService khoanMTService;
	
	
	@GetMapping("/listKMT")
	public String getListKhoanMT(Model model) {
		
		List<KhoanMienThueDTO> list = khoanMTService.getListKhoanMT();
		model.addAttribute("list", list);
		
		return "/kmt/listKMT";
		
	}
}
