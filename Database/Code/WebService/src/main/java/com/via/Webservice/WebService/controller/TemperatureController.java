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
@RequestMapping("/sep4")
public class TemperatureController {
	@Autowired
	TemperatureService service;
	
	@GetMapping("/temperature/{id}")
	public ResponseEntity<Temperature> findTemperatureById(@PathVariable("id") Integer id) {
		Optional<Temperature> temperature = service.findTemperatureById(id);
		if (temperature!=null) {
		
			//temperature.add(linkTo(methodOn(TemperatureController.class).getTemperatureById(id)).withSelfRel());


		return new ResponseEntity<Temperature>(HttpStatus.OK);
		}
		else 
			return new ResponseEntity<>( HttpStatus.NOT_FOUND);

	}
	@GetMapping("/temperatureAll")
	public ResponseEntity<Iterable<Temperature>> findAllTemperature() {
		Iterable<Temperature> list = service.findAllTemperature();
		Temperature temperature = new Temperature();
		temperature.add(linkTo(methodOn(TemperatureController.class).findAllTemperature()).withSelfRel());
		return new ResponseEntity<Iterable<Temperature>>(list, HttpStatus.OK);
	}

}
