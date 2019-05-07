package com.via.Webservice.WebService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.via.Webservice.WebService.model.Device;
import com.via.Webservice.WebService.service.DeviceService;

@RestController
@RequestMapping("/sep4")
public class DeviceController {
	@Autowired
	private DeviceService service;

	@GetMapping("/device/{id}")
	public ResponseEntity<Device> getDeviceById(@PathVariable("id") Integer id) {
		Device device = service.getDeviceById(id);
		return new ResponseEntity<Device>(device, HttpStatus.OK);
	}

}
