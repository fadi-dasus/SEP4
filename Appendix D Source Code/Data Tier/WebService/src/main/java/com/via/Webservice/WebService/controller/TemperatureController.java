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
	public ResponseEntity<Optional<Temperature>> getTemperatureById(@PathVariable("id") Integer id) {
		Optional<Temperature> temperature = service.getTemperatureById(id);
		if (temperature != null) {

			return new ResponseEntity<Optional<Temperature>>(temperature, HttpStatus.OK);
		} else
			return new ResponseEntity<Optional<Temperature>>(temperature, HttpStatus.NOT_FOUND);

	}


	@GetMapping("/room/{id}")
	public ResponseEntity<Iterable<Temperature>> getByTemperatureRoom(@PathVariable("id") int room_id) {
		Iterable<Temperature> list = service.getTemperatureByRoom(room_id);
		return new ResponseEntity<Iterable<Temperature>>(list, HttpStatus.OK);
	}

	@GetMapping("/roomtoday/{id}")
	public ResponseEntity<Iterable<Temperature>> findByRoomForToday(@PathVariable("id") int room_id) {
		Iterable<Temperature> list = service.getTemperatureByRoomForToday(room_id);
		return new ResponseEntity<Iterable<Temperature>>(list, HttpStatus.OK);
	}

}
