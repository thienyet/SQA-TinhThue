package com.example.BTL.service.impl;

import java.sql.Date;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.BTL.dao.TTNCNDao;
import com.example.BTL.dao.TaxerDao;
import com.example.BTL.entity.MaThue;
import com.example.BTL.entity.TTNCN;
import com.example.BTL.entity.Taxer;
import com.example.BTL.model.MaThueDTO;
import com.example.BTL.model.TTNCNDTO;
import com.example.BTL.model.TaxerDTO;
import com.example.BTL.model.ThueSuatDTO;
import com.example.BTL.service.TTNCNService;
import com.example.BTL.service.TaxerService;
import com.example.BTL.service.ThueSuatService;

@Service
@Transactional

public class TTNCNServiceImpl implements TTNCNService{

	@Autowired
	private TTNCNDao ttncnDao;
	
	@Autowired
	private TaxerService taxerService;
	
	@Autowired
	private ThueSuatService thueSuatService;
	
	@Override
	public List<TTNCNDTO> getListTTNCN() {
		NumberFormat numberFormat = NumberFormat.getInstance();
		List<TTNCNDTO> listTtncndtos = new ArrayList<TTNCNDTO>();
		List<TTNCN> listTtncns = ttncnDao.getListTTNCN();
		if (listTtncns==null && listTtncns.isEmpty())
			listTtncns=new ArrayList<>();
		for(TTNCN t: listTtncns) {
			TTNCNDTO ttncndto = new TTNCNDTO();
			ttncndto.setId(t.getId());
			MaThueDTO m = new MaThueDTO();
			m.setId(t.getMaThue().getId());
			m.setMaST(t.getMaThue().getMaST());
			ttncndto.setMathue(m);
			ttncndto.setAddress(t.getAddress());
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");		
			ttncndto.setBirdth(sdf.format(t.getBirdth()));
			ttncndto.setCard(t.getCard());
			TaxerDTO taxerDTO = taxerService.getTaxerById(t.getTaxer().getId());
			ttncndto.setTaxerDTO(taxerDTO);
			ttncndto.setName(t.getName());
			ttncndto.setStatus(t.getStatus());
			ttncndto.setThuetncn(t.getThuetncn());
			ttncndto.setThunhaptinhthue(t.getThunhaptinhthue());
			ttncndto.setTongthunhap(t.getTongthunhap());
			ttncndto.setThueTNCN(numberFormat.format(t.getThuetncn()));
			ttncndto.setThunhaptinhThue(numberFormat.format(t.getThunhaptinhthue()));
			ttncndto.setTongthuNhap(numberFormat.format(t.getTongthunhap()));
			
			listTtncndtos.add(ttncndto);
		}
		return listTtncndtos;
	}

	@Override
	public void add(TTNCNDTO t) {
		// TODO Auto-generated method stub
		TaxerDTO taxerDTO = taxerService.getTaxerById(t.getTaxerDTO().getId());
		if(taxerDTO.getThuesuat()!=0&&taxerDTO.getThuesuat()>0) {
			t.setThuetncn(t.getThunhaptinhthue()*taxerDTO.getThuesuat()/100);
		}else {
			List<ThueSuatDTO> listThueSuats = thueSuatService.getListThueSuat(t.getMathue().getId());
			for(ThueSuatDTO th : listThueSuats) {
				if(t.getTongthunhap()>=th.getLuongmin()&&(t.getTongthunhap()<=th.getLuongmax()||th.getLuongmax()==0)) {
					t.setThuetncn(t.getThunhaptinhthue()*th.getPhantramthue()/100);
					break;
				}
			}
		}
		TTNCN ttncn = new TTNCN();
		ttncn.setName(t.getName());
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		try {
			ttncn.setBirdth(new Date(sdf.parse(t.getBirdth()).getTime()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		MaThue mt = new MaThue();
		mt.setId(t.getMathue().getId());
		mt.setMaST(t.getMathue().getMaST());
		ttncn.setMaThue(mt);
		ttncn.setTongthunhap(t.getTongthunhap());
		ttncn.setThunhaptinhthue(t.getThunhaptinhthue());
		ttncn.setThuetncn(t.getThuetncn());
		Taxer taxer = new Taxer();
		taxer.setId(taxerDTO.getId());
		ttncn.setTaxer(taxer);
		ttncnDao.add(ttncn);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		TTNCN t = ttncnDao.getById(id);
		if(t!=null) {
			ttncnDao.delete(t);
		}
	}

	@Override
	public void update(TTNCNDTO t) {
		t.setThunhaptinhthue(Double.parseDouble(t.getThunhaptinhThue().replaceAll(",", "")));
		t.setTongthunhap(Double.parseDouble(t.getTongthuNhap().replaceAll(",", "")));
		TTNCN ttncn = new TTNCN();
		TaxerDTO taxerDTO = taxerService.getTaxerById(t.getTaxerDTO().getId());
		if(taxerDTO.getThuesuat()!=0&&taxerDTO.getThuesuat()>0) {
			t.setThuetncn(t.getThunhaptinhthue()*taxerDTO.getThuesuat()/100);
		}else {
			List<ThueSuatDTO> listThueSuats = thueSuatService.getListThueSuat(t.getMathue().getId());
			for(ThueSuatDTO th : listThueSuats) {
				if(t.getTongthunhap()>=th.getLuongmin()&&(t.getTongthunhap()<=th.getLuongmax()||th.getLuongmax()==0)) {
					t.setThuetncn(t.getThunhaptinhthue()*th.getPhantramthue()/100);
					break;
				}
			}
		}
		ttncn.setId(t.getId());
		
		ttncn.setName(t.getName());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		try {
			ttncn.setBirdth(new Date(sdf.parse(t.getBirdth()).getTime()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		MaThue mt = new MaThue();
		mt.setId(t.getMathue().getId());
		mt.setMaST(t.getMathue().getMaST());
		ttncn.setMaThue(mt);
		ttncn.setTongthunhap(t.getTongthunhap());
		ttncn.setThunhaptinhthue(t.getThunhaptinhthue());
		ttncn.setThuetncn(t.getThuetncn());
		Taxer taxer = new Taxer();
		taxer.setId(taxerDTO.getId());
		ttncn.setTaxer(taxer);
		ttncnDao.update(ttncn);
	}

	@Override
	public TTNCNDTO getById(int id) {
		// TODO Auto-generated method stub
		NumberFormat numberFormat = NumberFormat.getInstance();
		TTNCN t = ttncnDao.getById(id);
		
		TTNCNDTO ttncndto = new TTNCNDTO();
		ttncndto.setId(t.getId());
		MaThueDTO m = new MaThueDTO();
		m.setId(t.getMaThue().getId());
		m.setMaST(t.getMaThue().getMaST());
		ttncndto.setMathue(m);
		ttncndto.setAddress(t.getAddress());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		
		ttncndto.setBirdth(sdf.format(t.getBirdth()));
		ttncndto.setCard(t.getCard());
		
		ttncndto.setName(t.getName());
		ttncndto.setStatus(t.getStatus());
		ttncndto.setThuetncn(t.getThuetncn());
		ttncndto.setThunhaptinhthue(t.getThunhaptinhthue());
		ttncndto.setTongthunhap(t.getTongthunhap());
		ttncndto.setThueTNCN(numberFormat.format(t.getThuetncn()));
		ttncndto.setThunhaptinhThue(numberFormat.format(t.getThunhaptinhthue()));
		ttncndto.setTongthuNhap(numberFormat.format(t.getTongthunhap()));
		TaxerDTO taxerDTO = taxerService.getTaxerById(t.getTaxer().getId());
		ttncndto.setTaxerDTO(taxerDTO);
		return ttncndto;
	}

}
