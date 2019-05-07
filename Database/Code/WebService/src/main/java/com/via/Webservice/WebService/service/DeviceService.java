package com.via.Webservice.WebService.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.via.Webservice.WebService.dao.DeviceDAO;
import com.via.Webservice.WebService.model.Device;
import com.via.Webservice.WebService.model.Room;

@Service
public class DeviceService {
	DeviceDAO dao;
	
	public Optional<Device> getDeviceById(int id) {
		return dao.getDeviceById(id);
	}

	public List<Device> getAllDevice() {
		return dao.getAllDevice();
	}
	public Room getDeviceByName(String name) {
		return null;
			//	dao.getRoomByName(name);
	}

}
