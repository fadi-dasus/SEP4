package com.via.Webservice.WebService.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.via.Webservice.WebService.model.Co2;

@Transactional
@Repository
public class Co2DAO {

	@PersistenceContext
	@Autowired
	public EntityManager entityManager;

	public Co2 getCo2ById(int id) {
		return entityManager.find(Co2.class, id);
	}

	public List<Co2> getAllCo2() {
		String query = "select m from Co2 m order by m.value";

		return (List<Co2>) entityManager.createQuery(query).getResultList();
	}

}
