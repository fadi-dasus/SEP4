package com.via.Webservice.WebService.service.Device;

import java.util.Optional;

import com.via.Webservice.WebService.model.Device;

public interface IDeviceService {
	public Optional<Device> findDeviceById(int id);

	public Iterable<Device> findAllDevice();

}
