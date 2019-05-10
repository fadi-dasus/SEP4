package com.via.Webservice.WebService.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.via.Webservice.WebService.model.Temperature;
import com.via.Webservice.WebService.service.Temperature.TemperatureService;

@RestController
@RequestMapping("/sep4/temperature")
public class TemperatureController {
	@Autowired
	TemperatureService service;

	@GetMapping("/{id}")
	public ResponseEntity<Optional<Temperature>> findTemperatureById(@PathVariable("id") Integer id) {
		Optional<Temperature> temperature = service.findTemperatureById(id);
		if (temperature != null) {

			return new ResponseEntity<Optional<Temperature>>(temperature, HttpStatus.OK);
		} else
			return new ResponseEntity<Optional<Temperature>>(temperature, HttpStatus.NOT_FOUND);

	}

	@GetMapping("/all")
	public ResponseEntity<Iterable<Temperature>> findAllTemperature() {
		Iterable<Temperature> list = service.findAllTemperature();
		Temperature temperature = new Temperature();
		temperature.add(linkTo(methodOn(TemperatureController.class).findAllTemperature()).withSelfRel());
		return new ResponseEntity<Iterable<Temperature>>(list, HttpStatus.OK);
	}

	@GetMapping("/room/{id}")
	public ResponseEntity<Iterable<Temperature>> findByTemperatureRoom(@PathVariable("id") int room_id) {
		Iterable<Temperature> list = service.findByTemperatureRoom(room_id);
		return new ResponseEntity<Iterable<Temperature>>(list, HttpStatus.OK);
	}

	@GetMapping("/roomtoday/{id}")
	public ResponseEntity<Iterable<Temperature>> findByRoomForToday(@PathVariable("id") int room_id) {
		Iterable<Temperature> list = service.findByRoomForToday(room_id);
		return new ResponseEntity<Iterable<Temperature>>(list, HttpStatus.OK);
	}

}
