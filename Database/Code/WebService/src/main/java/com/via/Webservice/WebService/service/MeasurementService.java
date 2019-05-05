package com.via.Webservice.WebService.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.via.Webservice.WebService.dao.MeasurementDAO;
import com.via.Webservice.WebService.model.Measurement;

@Service
public class MeasurementService {
	@Autowired
	MeasurementDAO dao;
	
	public List<Measurement> getAllMeasurement() {
		return dao.getAllMeasurement();
	}

}
