package com.via.Webservice.WebService.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.via.Webservice.WebService.model.Measurement;

@Transactional
@Repository
public class MeasurementDAO {
	@PersistenceContext
	@Autowired
	public EntityManager entityManager;
	
	public List<Measurement> getAllMeasurement(){
		String query = "select m from Measurement";

		return (List<Measurement>) entityManager.createQuery(query).getResultList();

	}

}
