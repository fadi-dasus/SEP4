package com.via.Webservice.WebService.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.via.Webservice.WebService.dao.DeviceRepository;
import com.via.Webservice.WebService.model.Device;

@Service
public class DeviceService {
	@Autowired
	public DeviceRepository dao;
	
	public Optional<Device> findDeviceById(int id) {
		return dao.findById(id);
	}
	
	public Iterable<Device> findAllDevice() {
		return dao.findAll();
	}
	public List<Device> findByDiviceName(String name) {
		return dao.findByDeviceName(name);
	}

}
