package com.example.BTL.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.BTL.dao.AdminDao;
import com.example.BTL.entity.Admin;

@Repository
@Transactional
public class AdminDaoImpl implements AdminDao {
	
	@PersistenceContext
	EntityManager entityManager;
	
	@Override
	public void createAdmin(Admin admin) {
		// TODO Auto-generated method stub
		entityManager.persist(admin);
	}

	@Override
	public void deleteAdmin(Admin admin) {
		// TODO Auto-generated method stub
		entityManager.remove(admin);
	}

	@Override
	public void editAdmin(Admin admin) {
		try {
			entityManager.getTransaction().begin();
			
			String jpql = "UPDATE Admin a SET a.username = :auser, a.role = :arole WHERE a.id LIKE :aid ";
			Query query = entityManager.createQuery(jpql);
			query.setParameter("aid",  admin.getAdminid() );
			query.setParameter("auser",  admin.getUsername() );
			query.setParameter("arole",  admin.getRole() );
			
			entityManager.getTransaction().commit();
			entityManager.close();
		}catch (Exception e) {
			// TODO: handle exception
			System.out.print(e);
		
		}
	}

	@Override
	public Admin loginAdmin(String username) {
		// TODO Auto-generated method stub
		try {
			String jpql = "SELECT a FROM Admin a WHERE a.username LIKE :auser ";
			Query query = entityManager.createQuery(jpql);
			query.setParameter("auser",  username );
			return (Admin)query.getSingleResult();
		}catch (Exception e) {
			// TODO: handle exception
			System.out.print(e);
			return null;
		}
		
	}

	@Override
	public Admin getAdminByID(int id) {
		// TODO Auto-generated method stub
		try {
			String jpql = "SELECT a FROM Admin a WHERE a.adminid LIKE :aid ";
			Query query = entityManager.createQuery(jpql);
			query.setParameter("aid",  id );
			return (Admin)query.getSingleResult();
		}catch (Exception e) {
			// TODO: handle exception
			System.out.print(e);
			return null;
		}
	}

	@Override
	public List<Admin> getListPerson() {
		try {
			String jpql = "SELECT a FROM Admin a ";
			Query query = entityManager.createQuery(jpql);
			
			return query.getResultList();
		}catch (Exception e) {
			// TODO: handle exception
			System.out.print(e);
			return null;
		}
		
	}

}
