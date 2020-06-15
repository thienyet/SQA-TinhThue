package com.example.BTL.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.BTL.dao.TTNCNDao;
import com.example.BTL.entity.MaThue;
import com.example.BTL.entity.TTNCN;
import com.example.BTL.entity.ThueSuat;

@Repository
@Transactional
public class TTNCNDaoImpl implements TTNCNDao{
	
	@PersistenceContext
	EntityManager entityManager;

	@Override
	public List<TTNCN> getListTTNCN() {
		// TODO Auto-generated method stub
		/*
		 * CriteriaBuilder criteriaBuilder= entityManager.getCriteriaBuilder();
		 * CriteriaQuery<TTNCN> criteriaQuery =
		 * criteriaBuilder.createQuery(TTNCN.class);
		 * 
		 * Root<TTNCN> root= criteriaQuery.from(TTNCN.class); Join<TTNCN,MaThue>
		 * maThueEntity=root.join("mathue"); Join<MaThue,ThueSuat>
		 * thueSuatEntity=maThueEntity.join("maThue");
		 */
		try {
			String jpql = "SELECT t FROM TTNCN t ";
			Query query = entityManager.createQuery(jpql);
		
			return query.getResultList();
		}catch (Exception e) {
			// TODO: handle exception
			System.out.print(e);
			return null;
		}
				
	}

	@Override
	public void add(TTNCN t) {
		// TODO Auto-generated method stub
		entityManager.persist(t);
	}

	@Override
	public void delete(TTNCN t) {
		// TODO Auto-generated method stub
		entityManager.remove(t);
	}

	@Override
	public void update(TTNCN t) {
		// TODO Auto-generated method stub
		entityManager.merge(t);
	}

	@Override
	public TTNCN getById(int id) {
		// TODO Auto-generated method stub
		try {
			String jpql = "SELECT t FROM TTNCN t WHERE t.id LIKE :tid";
			Query query = entityManager.createQuery(jpql);
			query.setParameter("tid", id);
			return (TTNCN)query.getSingleResult();
		}catch (Exception e) {
			// TODO: handle exception
			System.out.print(e);
			return null;
		}
	}

}
