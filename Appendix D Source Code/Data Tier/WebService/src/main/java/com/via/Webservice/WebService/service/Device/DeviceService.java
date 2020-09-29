package com.via.Webservice.WebService.service.Device;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.via.Webservice.WebService.dao.Device.DeviceRepository;
import com.via.Webservice.WebService.model.Device;

@Service
public class DeviceService implements IDeviceService {
	@Autowired
	public DeviceRepository dao;

	public Optional<Device> getDeviceById(int id) {
		return dao.findById(id);
	}

	public Iterable<Device> getAllDevice() {
		return dao.findAll();
	}

	public List<Device> getDeviceByName(String name) {
		return dao.findByDeviceName(name);
	}

}
