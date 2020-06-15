package com.example.BTL.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.BTL.model.TaxerDTO;
import com.example.BTL.service.TaxerService;

@Controller
@RequestMapping("/admin")
public class TaxerController {
	@Autowired
	private TaxerService taxerService;
	
	@GetMapping("/listTaxer")
	public String getListTaxer(Model model) {
		List<TaxerDTO> list = taxerService.getListTaxer();
		model.addAttribute("list", list);
		return "/taxer/listTaxer";
	}
}

