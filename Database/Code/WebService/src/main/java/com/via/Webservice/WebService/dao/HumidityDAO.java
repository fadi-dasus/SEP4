package com.via.Webservice.WebService.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.via.Webservice.WebService.model.Humidity;

@Transactional
@Repository
public class HumidityDAO {
	@PersistenceContext
	@Autowired
	public EntityManager entityManager;
	
	public Humidity getHumidityById(int id) {
		return entityManager.find(Humidity.class, id);
	}

	public List<Humidity> getAllHumidity() {
		String query = "select m from Humidity m order by m.value";

		return (List<Humidity>) entityManager.createQuery(query).getResultList();
	}

}
