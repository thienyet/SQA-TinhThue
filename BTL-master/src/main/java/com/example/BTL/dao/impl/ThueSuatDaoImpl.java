package com.example.BTL.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.BTL.dao.ThueSuatDao;
import com.example.BTL.entity.ThueSuat;

@Repository
@Transactional
public class ThueSuatDaoImpl implements ThueSuatDao {

	
	@PersistenceContext
	EntityManager entityManager;
	
	@Override
	public List<ThueSuat> getListThueSuat(int id) {
		// TODO Auto-generated method stub
		try {
			String jpql = "SELECT t FROM ThueSuat t WHERE t.maThue.id LIKE :tid";
			Query query = entityManager.createQuery(jpql);
			query.setParameter("tid",  id );
			return query.getResultList();
		}catch (Exception e) {
			// TODO: handle exception
			System.out.print(e);
			return null;
		}
	}

	@Override
	public void add(ThueSuat t) {
		// TODO Auto-generated method stub
		entityManager.persist(t);
	}

	@Override
	public void edit(ThueSuat t) {
		// TODO Auto-generated method stub
		entityManager.merge(t);
	}

	@Override
	public void delete(ThueSuat t) {
		// TODO Auto-generated method stub
		entityManager.remove(t);
	}

	@Override
	public ThueSuat getById(int id) {
		try {
			String jpql = "SELECT t FROM ThueSuat t WHERE t.id LIKE :tid";
			Query query = entityManager.createQuery(jpql);
			query.setParameter("tid",  id );
			return (ThueSuat)query.getSingleResult();
		}catch (Exception e) {
			// TODO: handle exception
			System.out.print(e);
			return null;
		}
	}
	
}
