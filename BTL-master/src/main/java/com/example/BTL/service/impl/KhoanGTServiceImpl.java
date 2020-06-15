package com.example.BTL.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.BTL.dao.KhoanGTDao;
import com.example.BTL.entity.KhoanGiamTru;
import com.example.BTL.model.KhoanGiamTruDTO;
import com.example.BTL.service.KhoanGTService;

@Service
@Transactional
public class KhoanGTServiceImpl implements KhoanGTService{

	@Autowired
	private KhoanGTDao khoanGTDao;
	
	@Override
	public List<KhoanGiamTruDTO> getListKhoanGT() {
		// TODO Auto-generated method stub
		List<KhoanGiamTruDTO> liKhoanGiamTruDTOs = new ArrayList<KhoanGiamTruDTO>();
		List<KhoanGiamTru> liKhoanGiamTrus = khoanGTDao.getListKhoanGT();
		for(KhoanGiamTru k: liKhoanGiamTrus) {
			KhoanGiamTruDTO khoanGiamTruDTO = new KhoanGiamTruDTO();
			
			khoanGiamTruDTO.setMast(k.getMast());
			khoanGiamTruDTO.setGtnguoiphuthuoc(k.getGtnguoiphuthuoc());
			khoanGiamTruDTO.setGtbaohiem(k.getGtbaohiem());
			khoanGiamTruDTO.setGtbanthan(k.getGtbanthan());
			khoanGiamTruDTO.setTonggia(k.getTonggia());
			
			liKhoanGiamTruDTOs.add(khoanGiamTruDTO);
		}
		return liKhoanGiamTruDTOs;
	}
	
}
