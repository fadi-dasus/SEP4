package com.via.Webservice.WebService.dao.Device;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.via.Webservice.WebService.model.Device;

public interface DeviceRepository extends CrudRepository<Device, Integer> {

	public List<Device> findByDeviceName(String deviceName);

}
