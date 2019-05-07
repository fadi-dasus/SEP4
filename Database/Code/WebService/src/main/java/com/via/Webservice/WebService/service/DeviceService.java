package com.via.Webservice.WebService.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.via.Webservice.WebService.dao.DeviceDAO;
import com.via.Webservice.WebService.model.Device;

@Service
public class DeviceService {
	@Autowired
	public DeviceDAO dao;
	
	public Device getDeviceById(int id) {
		return dao.getDeviceById(id);
	}

	

}
