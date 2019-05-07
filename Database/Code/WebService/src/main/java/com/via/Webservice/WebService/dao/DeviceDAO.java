package com.via.Webservice.WebService.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.via.Webservice.WebService.model.Device;

@Transactional
@Repository
public class DeviceDAO {
	@Autowired
	public DeviceRepository deviceRepository;
	public Optional<Device> getDeviceById(int id) {
		return deviceRepository.findById(id);
	}

	public List<Device> getAllDevice() {

		return (List<Device>) deviceRepository.findAll();

	}

}
