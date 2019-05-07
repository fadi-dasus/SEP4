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

import com.via.Webservice.WebService.model.Humidity;
import com.via.Webservice.WebService.service.HumidityService;

@RestController
@RequestMapping("/sep4")
public class HumidityController {
	@Autowired
	HumidityService service;
	
	@GetMapping("/humidity/{id}")
	public ResponseEntity<Humidity> getHumidityById(@PathVariable("id") Integer id) {
		Optional<Humidity> humidity = service.getHumidityById(id);
		if (humidity!=null) {
//			humidity.add(linkTo(methodOn(HumidityController.class).getHumidityById(id)).withSelfRel());


		return new ResponseEntity<Humidity>(HttpStatus.OK);
		}
		else 
			return new ResponseEntity<>( HttpStatus.NOT_FOUND);

	}

	@GetMapping("/humidityAll")
	public ResponseEntity<List<Humidity>> getAllHumidity() {
		List<Humidity> list = service.getAllHumidity();
		Humidity humidity = new Humidity();
		humidity.add(linkTo(methodOn(HumidityController.class).getAllHumidity()).withSelfRel());
		return new ResponseEntity<List<Humidity>>(list, HttpStatus.OK);

	}

}
