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

import com.example.BTL.model.MaThueDTO;
import com.example.BTL.model.ThueSuatDTO;
import com.example.BTL.service.MaThueService;
import com.example.BTL.service.ThueSuatService;

@Controller
@RequestMapping("/admin")
public class MaThueController {
	
	@Autowired
	MaThueService maThueService;
	
	@Autowired 
	ThueSuatService thueSuatService;
	
	@GetMapping("/listMT")
	public String getMaThue(Model model) {
		List<MaThueDTO> list = maThueService.getListMT();
		model.addAttribute("list",list);
		return "/mt/listMT";
	}
	
	@GetMapping("/addMT")
	public String addMaThue(Model model) {
		MaThueDTO maThueDTO = new MaThueDTO();
		model.addAttribute("maThueDTO", maThueDTO);
		return "/mt/addMT";
	}
	
	@PostMapping("/addMT")
	public String postAddMT(@ModelAttribute(name="maThueDTO") MaThueDTO maThueDTO) {
		if(maThueDTO!=null) {
			maThueService.createMT(maThueDTO);
		}
		return "redirect:/admin/listMT";
	}
	
	@GetMapping("/deleteMT")
	public String deleteMaThue(@RequestParam(name="id") String id) {
		
		if(id!=null) {
			maThueService.delete(Integer.parseInt(id));
		}
		
		return "redirect:/admin/listMT";
	}
	
	@GetMapping("/editMT")
	public String editMaThue(@RequestParam(name="id", required = false) String id,
			Model model) {
		
		MaThueDTO maThueDTO = maThueService.getById(Integer.parseInt(id));
		model.addAttribute("DTO", maThueDTO);

		return "/mt/editMT";
	}
	
	@PostMapping("/editMT")
	public String postEditMT(@ModelAttribute(name="maThueDTO") MaThueDTO maThueDTO) {
		if(maThueDTO!=null) {
			maThueService.update(maThueDTO);
		}
		return "redirect:/admin/listMT";
	}
	@GetMapping("/detailMT")
	public String getDetail(@RequestParam(name="id",required = false) String id,
			Model model) {
		MaThueDTO maThueDTO = maThueService.getById(Integer.parseInt(id));
		model.addAttribute("maThueDTO", maThueDTO);
		List<ThueSuatDTO> list = thueSuatService.getListThueSuat(Integer.parseInt(id));
		model.addAttribute("list", list);
		ThueSuatDTO thueSuatDTO = new ThueSuatDTO();
		model.addAttribute("ThueSuatDTO", thueSuatDTO);
		return "/ts/listTS";
	}
}
