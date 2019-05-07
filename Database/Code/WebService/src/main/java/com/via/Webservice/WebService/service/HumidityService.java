package com.via.Webservice.WebService.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.via.Webservice.WebService.dao.HumidityDAO;
import com.via.Webservice.WebService.model.Humidity;

@Service
public class HumidityService {

	@Autowired
	HumidityDAO dao;
	
	public Optional<Humidity> getHumidityById(int id) {
		return dao.getHumidityById(id);
	}

	public List<Humidity> getAllHumidity() {
		return dao.getAllHumidity();
	}
}
