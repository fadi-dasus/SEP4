package com.via.Webservice.WebService.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.via.Webservice.WebService.model.Device;
import com.via.Webservice.WebService.service.Device.DeviceService;

@RestController
@RequestMapping("/sep4/device")
public class DeviceController {
	@Autowired
	DeviceService service;

	@GetMapping("/{id}")
	public ResponseEntity<Optional<Device>> getDeviceById(@PathVariable("id") int id) {
		Optional<Device> device = service.getDeviceById(id);
		System.out.println(device.toString());
		return new ResponseEntity<Optional<Device>>(device, HttpStatus.OK);

	}

	@GetMapping("/all")
	public ResponseEntity<Iterable<Device>> getAllDevice() {
		Iterable<Device> list = service.getAllDevice();
		Device device = new Device();
		device.add(linkTo(methodOn(DeviceController.class).getAllDevice()).withSelfRel());
		return new ResponseEntity<Iterable<Device>>(list, HttpStatus.OK);

	}

	@GetMapping("/name")
	public ResponseEntity<List<Device>> getDeviceByName(@RequestParam("name") String name) {
		List<Device> device = service.getDeviceByName(name);
		if (device != null) {
			return new ResponseEntity<List<Device>>(device,HttpStatus.OK);
		} else
			return new ResponseEntity<List<Device>>(device,HttpStatus.NOT_FOUND);

	}

}
