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

import com.example.BTL.model.ThueSuatDTO;
import com.example.BTL.service.ThueSuatService;

@Controller
@RequestMapping("/admin")
public class ThueSuatController {

	
	@Autowired
	private ThueSuatService thueSuatService;
	
//	@GetMapping("/listTS")
//	public String getListThueSuat(Model model) {
//		
//		List<ThueSuatDTO> list = thueSuatService.getListThueSuat();
//		model.addAttribute("list", list);
//		
//		return "/ts/listTS";
//	}
	
	@GetMapping("/deleteTS")
	public String deleteTS(@RequestParam(name="id", required = false) String id,
			@RequestParam(name="id_mast") String mast) {
		if(id!=null) {
			 thueSuatService.delete(Integer.parseInt(id));
			
		}
		return "redirect:/admin/detailMT?id="+Integer.parseInt(mast);
	}
	
	@GetMapping("/editTS")
	public String getEdit(@RequestParam(name="id",required = false) String id,
			Model model) {
		if(id!=null) {
			ThueSuatDTO thueSuatDTO = thueSuatService.getById(Integer.parseInt(id));
			model.addAttribute("ThueSuatDTO", thueSuatDTO);
		}else {
			ThueSuatDTO thueSuatDTO = new ThueSuatDTO();
			model.addAttribute("ThueSuatDTO", thueSuatDTO);
		}
		
		return "/ts/editTS";
	}
	
	@PostMapping("/editTS")
	public String postEdit(@ModelAttribute(name="ThueSuatDTO") ThueSuatDTO thueSuatDTO) {
		thueSuatService.edit(thueSuatDTO);
		return "redirect:/admin/detailMT?id="+thueSuatDTO.getId_mast();
	}
	
	@PostMapping("/addTS")
	public String postAdd(@ModelAttribute(name="ThueSuatDTO")ThueSuatDTO thueSuatDTO,
			@RequestParam(name="id_mast") String id_mast) {
		if(thueSuatDTO!=null) {
			thueSuatService.add(thueSuatDTO);
			
		}
		System.out.print(thueSuatDTO.getId_mast());
		return "redirect:/admin/detailMT?id="+thueSuatDTO.getId_mast();
	}
	
	
	
}
