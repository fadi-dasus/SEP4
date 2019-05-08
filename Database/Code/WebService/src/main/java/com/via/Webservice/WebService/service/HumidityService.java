package com.via.Webservice.WebService.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.via.Webservice.WebService.dao.HumidityRepository;
import com.via.Webservice.WebService.model.Humidity;

@Service
public class HumidityService {

	@Autowired
	HumidityRepository dao;
	
	public Optional<Humidity> findHumidityById(int id) {
		return dao.findById(id);
	}

	public Iterable<Humidity> findAllHumidity() {
		return dao.findAll();
	}
}
