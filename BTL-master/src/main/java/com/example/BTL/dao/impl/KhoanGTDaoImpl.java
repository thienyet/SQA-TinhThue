package com.example.BTL.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.BTL.dao.KhoanGTDao;
import com.example.BTL.entity.KhoanGiamTru;

@Repository
@Transactional
public class KhoanGTDaoImpl implements KhoanGTDao{

	
	@PersistenceContext
	EntityManager entityManager;
	
	@Override
	public List<KhoanGiamTru> getListKhoanGT() {
		// TODO Auto-generated method stub
		try {
			String jpql = "SELECT k FROM KhoanGiamTru k ";
			Query query = entityManager.createQuery(jpql);
			return query.getResultList();
		}catch (Exception e) {
			// TODO: handle exception
			System.out.print(e);
			return null;
		}
	}
	
}
