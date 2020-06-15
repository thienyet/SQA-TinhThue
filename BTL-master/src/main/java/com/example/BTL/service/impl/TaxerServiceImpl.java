package com.example.BTL.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.BTL.dao.TaxerDao;
import com.example.BTL.entity.Taxer;
import com.example.BTL.model.TaxerDTO;
import com.example.BTL.service.TaxerService;

@Service
@Transactional
public class TaxerServiceImpl implements TaxerService{
	
	@Autowired
	private TaxerDao taxerDao;

	@Override
	public List<TaxerDTO> getListTaxer() {
		List<TaxerDTO> lisTaxerDTOs= new ArrayList<TaxerDTO>();
		List<Taxer> lisTaxers = taxerDao.getListTaxer();
		for(Taxer taxer: lisTaxers) {
			TaxerDTO taxerDTO = new TaxerDTO();
			taxerDTO.setId(taxer.getId());
			taxerDTO.setName(taxer.getName());
			taxerDTO.setDescription(taxer.getDescription());
			taxerDTO.setThuesuat(taxer.getThuesuat());
			lisTaxerDTOs.add(taxerDTO);
		}
		return lisTaxerDTOs;
	}

	@Override
	public TaxerDTO getTaxerById(int id) {
		// TODO Auto-generated method stub
		Taxer taxer = taxerDao.getTaxerById(id);
		TaxerDTO taxerDTO = new TaxerDTO();
		taxerDTO.setId(taxer.getId());
		taxerDTO.setName(taxer.getName());
		taxerDTO.setDescription(taxer.getDescription());
		taxerDTO.setThuesuat(taxer.getThuesuat());
		return taxerDTO;
	}

}
