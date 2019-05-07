package com.via.Webservice.WebService.dao;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.via.Webservice.WebService.model.Temperature;

@Transactional
@Repository
public class TemperatureDAO {
	@Autowired
	public TemperatureRepository temperatureRepository;
	
	
	public Optional<Temperature> getTemperatureById(int id) {
		return temperatureRepository.findById(id);
	}

	public List<Temperature> getAllTemperature() {
		

		return (List<Temperature>) temperatureRepository.findAll();
	}

}
