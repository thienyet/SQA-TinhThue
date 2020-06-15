package com.example.BTL.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.BTL.dao.TaxerDao;
import com.example.BTL.entity.Taxer;

@Repository
@Transactional
public class TaxerDaoImpl implements TaxerDao{

	@PersistenceContext
	EntityManager entityManager;
	
	@Override
	public List<Taxer> getListTaxer() {
		// TODO Auto-generated method stub
		try {
			String jpql = "SELECT t FROM Taxer t ";
			Query query = entityManager.createQuery(jpql);
		
			return query.getResultList();
		}catch (Exception e) {
			// TODO: handle exception
			System.out.print(e);
			return null;
		}
		
	}

	@Override
	public Taxer getTaxerById(int id) {
		try {
			String jpql = "SELECT t FROM Taxer t WHERE t.id LIKE :tid";
			Query query = entityManager.createQuery(jpql);
			query.setParameter("tid", id);
			return (Taxer)query.getSingleResult();
		}catch (Exception e) {
			// TODO: handle exception
			System.out.print(e);
			return null;
		}
	}

}
