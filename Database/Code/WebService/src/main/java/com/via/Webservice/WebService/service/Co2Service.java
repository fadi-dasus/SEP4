package com.via.Webservice.WebService.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.via.Webservice.WebService.dao.Co2DAO;
import com.via.Webservice.WebService.model.Co2Test;

@Service
public class Co2Service {

	@Autowired
	Co2DAO dao;

	public Co2Test getCo2ById(int id) {
		return dao.getCo2ById(id);
	}

	public List<Co2Test> getAllCo2() {
		return dao.getAllCo2();
	}
}
