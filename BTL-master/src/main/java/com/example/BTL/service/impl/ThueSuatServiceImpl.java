package com.example.BTL.service.impl;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.BTL.dao.MaThueDao;
import com.example.BTL.dao.ThueSuatDao;
import com.example.BTL.entity.ThueSuat;
import com.example.BTL.model.ThueSuatDTO;
import com.example.BTL.service.ThueSuatService;

@Service
@Transactional
public class ThueSuatServiceImpl implements ThueSuatService {
	
	@Autowired
	private ThueSuatDao thueSuatDao;
	@Autowired
	private MaThueDao maThueDao;

	@Override
	public List<ThueSuatDTO> getListThueSuat(int id) {
		NumberFormat numberFormat = NumberFormat.getInstance();
		// TODO Auto-generated method stub
		List<ThueSuatDTO> liThueSuatDTOs = new ArrayList<ThueSuatDTO>();
		List<ThueSuat> liThueSuats = thueSuatDao.getListThueSuat( id);
		
		for(ThueSuat t: liThueSuats) {
			ThueSuatDTO thueSuatDTO = new ThueSuatDTO();
			thueSuatDTO.setId(t.getId());
			thueSuatDTO.setBacthue(t.getBacthue());
			thueSuatDTO.setLuongmax(t.getLuongmax());
			thueSuatDTO.setLuongmin(t.getLuongmin());
			thueSuatDTO.setPhantramthue(t.getPhantramthue());
			thueSuatDTO.setTiengiamTU(t.getTiengiamTU());
			thueSuatDTO.setLuongMin(numberFormat.format(thueSuatDTO.getLuongmin()));
			thueSuatDTO.setLuongMax(numberFormat.format(thueSuatDTO.getLuongmax()));
			thueSuatDTO.setId_mast(t.getMaThue().getId());
			liThueSuatDTOs.add(thueSuatDTO);
		}
		
		return liThueSuatDTOs;
	}

	@Override
	public void add(ThueSuatDTO t) {
		// TODO Auto-generated method stub
		ThueSuat thueSuat = new ThueSuat();
		thueSuat.setBacthue(t.getBacthue());
		thueSuat.setLuongmax(t.getLuongmax());
		thueSuat.setLuongmin(t.getLuongmin());
		thueSuat.setMaThue(maThueDao.getById(t.getId_mast()));
		thueSuat.setPhantramthue(t.getPhantramthue());
		thueSuat.setTiengiamTU(t.getTiengiamTU());
		
		thueSuatDao.add(thueSuat);
	}

	@Override
	public void edit(ThueSuatDTO t) {
		// TODO Auto-generated method stub
		ThueSuat thueSuat = new ThueSuat();
		thueSuat.setBacthue(t.getBacthue());
		thueSuat.setLuongmax(t.getLuongmax());
		thueSuat.setLuongmin(t.getLuongmin());
		thueSuat.setMaThue(maThueDao.getById(t.getId_mast()));
		thueSuat.setPhantramthue(t.getPhantramthue());
		thueSuat.setTiengiamTU(t.getTiengiamTU());
		thueSuat.setId(t.getId());
		
		thueSuatDao.edit(thueSuat);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		ThueSuat thueSuat= thueSuatDao.getById(id);
		thueSuatDao.delete(thueSuat);
	}

	@Override
	public ThueSuatDTO getById(int id) {
		NumberFormat numberFormat = NumberFormat.getInstance();
		ThueSuat t = thueSuatDao.getById(id);
		
		ThueSuatDTO thueSuatDTO = new ThueSuatDTO();
		thueSuatDTO.setId(t.getId());
		thueSuatDTO.setBacthue(t.getBacthue());
		thueSuatDTO.setLuongmax(t.getLuongmax());
		thueSuatDTO.setLuongmin(t.getLuongmin());
		thueSuatDTO.setPhantramthue(t.getPhantramthue());
		thueSuatDTO.setTiengiamTU(t.getTiengiamTU());
		thueSuatDTO.setLuongMin(numberFormat.format(thueSuatDTO.getLuongmin()));
		thueSuatDTO.setLuongMax(numberFormat.format(thueSuatDTO.getLuongmax()));
		thueSuatDTO.setId_mast(t.getMaThue().getId());
		
		return thueSuatDTO;
	}

}
