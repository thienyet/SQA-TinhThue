package com.example.BTL.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.BTL.dao.KhoanMTDao;
import com.example.BTL.entity.KhoanMienThue;

@Repository
@Transactional
public class KhoanMTDaoImpl implements KhoanMTDao{
	
	@PersistenceContext
	EntityManager entityManager;
	
	@Override
	public List<KhoanMienThue> getListKhoanMT() {
		try {
			String jpql = "SELECT k FROM KhoanMienThue k ";
			Query query = entityManager.createQuery(jpql);
			return query.getResultList();
		}catch (Exception e) {
			// TODO: handle exception
			System.out.print(e);
			return null;
		}
	}

}
