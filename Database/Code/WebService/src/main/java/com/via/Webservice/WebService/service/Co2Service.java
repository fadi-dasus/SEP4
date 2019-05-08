package com.via.Webservice.WebService.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.via.Webservice.WebService.dao.Co2Respository;
import com.via.Webservice.WebService.model.Co2;

@Service
public class Co2Service {

	@Autowired
	Co2Respository dao;

	public Optional<Co2> findCo2ById(int id) {
		return dao.findById(id);
	}

	public Iterable<Co2> findAllCo2() {
		return dao.findAll();
	}
}
