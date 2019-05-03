package com.via.Webservice.WebService.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.via.Webservice.WebService.model.Admin;

@Transactional
@Repository
public class AdminDAO {
	@PersistenceContext
	@Autowired
	public EntityManager entityManager;
	
	public Admin getAdminById(int id) {
		return entityManager.find(Admin.class, id);
	}
	public Admin getAdminByName(String username) {
		return entityManager.find(Admin.class, username);
	}
	
	public boolean adminExist(String username) {

		String jpql = "from Admin as m WHERE m.username = ?0 ";
		int count = entityManager.createQuery(jpql).setParameter(0, username).getResultList().size();
		return count > 0;

	}

	public void addAdmin(Admin admin) {

		entityManager.persist(admin);

	}

}
