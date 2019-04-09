package com.via.Webservice.WebService.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.via.Webservice.WebService.model.Co2Test;

@Transactional
@Repository
public class Co2DAO {

	@PersistenceContext
	@Autowired
	public EntityManager entityManager;

	public Co2Test getCo2ById(int id) {
		return entityManager.find(Co2Test.class, id);
	}

	public List<Co2Test> getAllCo2() {
		String query = "select m from Co2 m order by m.value";

		return (List<Co2Test>) entityManager.createQuery(query).getResultList();
	}

}
