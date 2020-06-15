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
import com.example.BTL.model.TTNCNDTO;
import com.example.BTL.model.TaxerDTO;
import com.example.BTL.service.MaThueService;
import com.example.BTL.service.TTNCNService;
import com.example.BTL.service.TaxerService;

@Controller
@RequestMapping("/admin")
public class TTNCNController {
	@Autowired
	private TTNCNService ttncnService;
	
	@Autowired
	private MaThueService maThueService;
	
	@Autowired 
	private TaxerService taxerService;
	
	@GetMapping("/listTTNCN")
	public String getListTTNCN(Model model) {
		
		List<TTNCNDTO> list = ttncnService.getListTTNCN();
		model.addAttribute("list", list);
		return "/ttncn/list";
	}
	
	@GetMapping("/deleteTTNCN")
	public String delete(@RequestParam(name="id",required = false) String id) {
		if(id!=null) {
			ttncnService.delete(Integer.parseInt(id));
		}
		return "redirect:/admin/listTTNCN";
	}
	
	@GetMapping("/editTTNCN")
	public String getEdit(@RequestParam(name="id",required = false) String id,
			Model model) {
		System.out.print(id);
		TTNCNDTO ttncndto = ttncnService.getById(Integer.parseInt(id));
		model.addAttribute("TTNCN",ttncndto);
		
		List<MaThueDTO> maThueDTO = maThueService.getListMT();
		model.addAttribute("mathue", maThueDTO);
		
		List<TaxerDTO> taxerDTOs = taxerService.getListTaxer();
		model.addAttribute("taxers", taxerDTOs);
		
		return "/ttncn/edit";
	}
	
	@PostMapping("/editTTNCN")
	public String postEdit(@ModelAttribute(name="TTNCN") TTNCNDTO ttncndto) {
		if(ttncndto!=null&& ttncndto.getMathue()!=null && ttncndto.getId()!=0) {
			ttncnService.update(ttncndto);
		}
		return "redirect:/admin/listTTNCN";
	}
		
	@GetMapping("/addTTNCN")
	public String getAdd(Model model) {
		TTNCNDTO ttncndto = new TTNCNDTO();
		model.addAttribute("TTNCN", ttncndto);
		
		List<MaThueDTO> liMaThueDTOs = maThueService.getListMT();
		model.addAttribute("mathue", liMaThueDTOs);
		
		List<TaxerDTO> taxerDTOs = taxerService.getListTaxer();
		model.addAttribute("taxers", taxerDTOs);
		return "/ttncn/add";
	}
	
	
	@PostMapping("/addTTNCN")
	public String postAdd(@ModelAttribute(name="TTNCN") TTNCNDTO ttncndto) {
		if(ttncndto!=null) {
			ttncnService.add(ttncndto);
		}
		return "redirect:/admin/listTTNCN";
	}
	
}
