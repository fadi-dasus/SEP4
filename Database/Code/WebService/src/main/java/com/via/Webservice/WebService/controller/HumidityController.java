package com.via.Webservice.WebService.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.via.Webservice.WebService.model.Humidity;
import com.via.Webservice.WebService.service.Humidity.HumidityService;

@RestController
@RequestMapping("/sep4/humidity")
public class HumidityController {
	@Autowired
	HumidityService service;

	@GetMapping("/{id}")
	public ResponseEntity<Optional<Humidity>> getHumidityById(@PathVariable("id") Integer id) {
		Optional<Humidity> humidity = service.getHumidityById(id);
		if (humidity != null) {

			return new ResponseEntity<Optional<Humidity>>(humidity, HttpStatus.OK);
		} else
			return new ResponseEntity<Optional<Humidity>>(humidity, HttpStatus.NOT_FOUND);

	}

//	@GetMapping("/all")
//	public ResponseEntity<Iterable<Humidity>> getAllHumidity() {
//		Iterable<Humidity> list = service.getAll();
//		Humidity humidity = new Humidity();
//		humidity.add(linkTo(methodOn(HumidityController.class).findAllHumidity()).withSelfRel());
//		return new ResponseEntity<Iterable<Humidity>>(list, HttpStatus.OK);
//	}

	@GetMapping("/room/{id}")
	public ResponseEntity<Iterable<Humidity>> getHumidityByRoom(@PathVariable("id") int room_id) {
		Iterable<Humidity> list = service.getHumidityByRoom(room_id);
		return new ResponseEntity<Iterable<Humidity>>(list, HttpStatus.OK);
	}

	@GetMapping("/roomtoday/{id}")
	public ResponseEntity<Iterable<Humidity>> getHumidityByRoomForToday(@PathVariable("id") int room_id) {
		Iterable<Humidity> list = service.getHumidityByRoomForToday(room_id);
		return new ResponseEntity<Iterable<Humidity>>(list, HttpStatus.OK);
	}

}
