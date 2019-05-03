package com.via.Webservice.WebService.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.via.Webservice.WebService.model.Temperature;

@Transactional
@Repository
public class TemperatureDAO {
	@PersistenceContext
	@Autowired
	public EntityManager entityManager;
	
	
	public Temperature getTemperatureById(int id) {
		return entityManager.find(Temperature.class, id);
	}

	public List<Temperature> getAllTemperature() {
		String query = "select m from Temperature m order by m.value";

		return (List<Temperature>) entityManager.createQuery(query).getResultList();
	}

}
