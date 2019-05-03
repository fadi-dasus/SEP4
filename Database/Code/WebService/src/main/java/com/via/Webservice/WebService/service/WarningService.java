package com.via.Webservice.WebService.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.via.Webservice.WebService.dao.WarningDAO;
import com.via.Webservice.WebService.model.Warning;

@Service
public class WarningService {
	
	@Autowired
	WarningDAO dao;
	public List<Warning> getAllWarning() {
		return dao.getAllWarnings();
	}
}
