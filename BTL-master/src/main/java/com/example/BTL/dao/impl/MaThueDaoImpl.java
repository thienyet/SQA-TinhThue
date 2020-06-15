package com.example.BTL.dao.impl;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.BTL.dao.MaThueDao;
import com.example.BTL.entity.MaThue;

@Repository
@Transactional
public class MaThueDaoImpl implements MaThueDao{

	@PersistenceContext
	EntityManager entityManager;
	
	@Override
	public List<MaThue> getListMT() {
		try {
			String jpql = "SELECT m FROM MaThue m ";
			Query query = entityManager.createQuery(jpql);
			return query.getResultList();
		}catch (Exception e) {
			// TODO: handle exception
			System.out.print(e);
			return null;
		}
		 
	}

	@Override
	public void createMT(MaThue m) {
		// TODO Auto-generated method stub
		entityManager.persist(m);
	}

	@Override
	public void delete(MaThue m) {
		// TODO Auto-generated method stub
		entityManager.remove(m);
	}

	@Override
	public void update(MaThue m) {
		// TODO Auto-generated method stub
		entityManager.merge(m);
	}

	@Override
	public MaThue getById(int id) {
		try {
			String jpql = "SELECT m FROM MaThue m WHERE m.id LIKE :mid";
			Query query = entityManager.createQuery(jpql);
			query.setParameter("mid",  id );
			return (MaThue)query.getSingleResult();
		}catch (Exception e) {
			// TODO: handle exception
			System.out.print(e);
			return null;
		}
	}

}
