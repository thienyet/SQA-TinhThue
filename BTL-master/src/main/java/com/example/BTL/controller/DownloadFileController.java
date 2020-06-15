package com.example.BTL.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.BTL.model.GenerateExcelReport;
import com.example.BTL.model.TTNCNDTO;
import com.example.BTL.service.TTNCNService;

@Controller
@RequestMapping("/admin")
public class DownloadFileController {

	@Autowired
	private TTNCNService ttncnService;

	@GetMapping("/downloadExcell")
	public ResponseEntity<InputStreamResource> excelReport() throws IOException {
		List<TTNCNDTO> list = (List<TTNCNDTO>) ttncnService.getListTTNCN();
		ByteArrayInputStream in = GenerateExcelReport.usersToExcel(list);
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Disposition", "attachment; filename=ttncns.xlsx");
		return ResponseEntity.ok().headers(headers).body(new InputStreamResource(in));
	}
}
