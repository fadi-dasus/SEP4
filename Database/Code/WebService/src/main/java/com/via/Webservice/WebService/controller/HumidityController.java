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

import com.via.Webservice.WebService.model.Humidity;
import com.via.Webservice.WebService.service.HumidityService;

@RestController
@RequestMapping("/sep4")
public class HumidityController {
	@Autowired
	HumidityService service;
	
	@GetMapping("/humidity/{id}")
	public ResponseEntity<Humidity> findHumidityById(@PathVariable("id") Integer id) {
		Optional<Humidity> humidity = service.findHumidityById(id);
		if (humidity!=null) {
//			humidity.add(linkTo(methodOn(HumidityController.class).getHumidityById(id)).withSelfRel());


		return new ResponseEntity<Humidity>(HttpStatus.OK);
		}
		else 
			return new ResponseEntity<>( HttpStatus.NOT_FOUND);

	}

	@GetMapping("/humidityAll")
	public ResponseEntity<Iterable<Humidity>> findAllHumidity() {
		Iterable<Humidity> list = service.findAllHumidity();
		Humidity humidity = new Humidity();
		humidity.add(linkTo(methodOn(HumidityController.class).findAllHumidity()).withSelfRel());
		return new ResponseEntity<Iterable<Humidity>>(list, HttpStatus.OK);

	}

}
