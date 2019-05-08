package com.via.Webservice.WebService.service;

import java.util.Optional;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.via.Webservice.WebService.dao.TemperatureRepository;
import com.via.Webservice.WebService.model.Temperature;
@Service
public class TemperatureService {
	
	@Autowired
	TemperatureRepository dao;
	public EntityManager entityManager;
	
	public Optional<Temperature> findTemperatureById(int id) {
		return dao.findById(id);
	}

	public Iterable<Temperature> findAllTemperature() {
		return dao.findAll();
	}

}
