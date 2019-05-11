package com.via.Webservice.WebService.service.Device;

import java.util.List;
import java.util.Optional;

import com.via.Webservice.WebService.model.Device;

public interface IDeviceService {
	public Optional<Device> getDeviceById(int id);

	public Iterable<Device> getAllDevice();

	public List<Device> getDeviceByName(String name);

}
