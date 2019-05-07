package com.via.Webservice.WebService.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.via.Webservice.WebService.dao.TemperatureDAO;
import com.via.Webservice.WebService.model.Temperature;
@Service
public class TemperatureService {
	
	@Autowired
	TemperatureDAO dao;
	public EntityManager entityManager;
	
	public Optional<Temperature> getTemperatureById(int id) {
		return dao.getTemperatureById(id);
	}

	public List<Temperature> getAllTemperature() {
		return dao.getAllTemperature();
	}

}
