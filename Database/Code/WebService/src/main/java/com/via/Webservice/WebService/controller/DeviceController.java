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
import org.springframework.web.bind.annotation.RestController;

import com.via.Webservice.WebService.model.Device;
import com.via.Webservice.WebService.service.DeviceService;

@RestController
@RequestMapping("/sep4")
public class DeviceController {
	@Autowired
	DeviceService service;
	
	@GetMapping("/device/{id}")
	public ResponseEntity<Device> getDeviceById(@PathVariable("id") Integer id) {
		Optional<Device> room = service.getDeviceById(id);
		if (room!=null) {
		
		
			//room.add(linkTo(methodOn(RoomController.class).getRoomById(id)).withSelfRel());


		return new ResponseEntity<Device>(HttpStatus.OK);
		}
		else 
			return new ResponseEntity<>( HttpStatus.NOT_FOUND);

	}

	@GetMapping("/deviceAll")
	public ResponseEntity<List<Device>> getAllDevice() {
		List<Device> list = service.getAllDevice();
		Device device = new Device();
		device.add(linkTo(methodOn(RoomController.class).getAllRoom()).withSelfRel());
		return new ResponseEntity<List<Device>>(list, HttpStatus.OK);

	}
}
