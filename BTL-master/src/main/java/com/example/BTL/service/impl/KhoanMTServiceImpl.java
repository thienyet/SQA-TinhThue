package com.example.BTL.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.BTL.dao.KhoanMTDao;
import com.example.BTL.entity.KhoanMienThue;
import com.example.BTL.model.KhoanMienThueDTO;
import com.example.BTL.service.KhoanMTService;

@Service
@Transactional
public class KhoanMTServiceImpl implements KhoanMTService{

	@Autowired
	private KhoanMTDao  khoanMTDao;
	
	@Override
	public List<KhoanMienThueDTO> getListKhoanMT() {
		// TODO Auto-generated method stub
		List<KhoanMienThueDTO> liKhoanMienThueDTOs = new ArrayList<KhoanMienThueDTO>();
		List<KhoanMienThue> liKhoanMienThues = khoanMTDao.getListKhoanMT();
		
		for(KhoanMienThue k : liKhoanMienThues) {
			
			KhoanMienThueDTO khoanMienThueDTO = new KhoanMienThueDTO();
			khoanMienThueDTO.setMast(k.getMast());
			khoanMienThueDTO.setTienan(k.getTienan());
			khoanMienThueDTO.setTiendc(k.getTiendc());
			khoanMienThueDTO.setTiendt(k.getTiendt());
			khoanMienThueDTO.setTienkhac(k.getTienkhac());
			khoanMienThueDTO.setTientp(k.getTientp());
			khoanMienThueDTO.setTongmien(k.getTongmien());
			
			liKhoanMienThueDTOs.add(khoanMienThueDTO);
		}
		
		return liKhoanMienThueDTOs;
	}

}
