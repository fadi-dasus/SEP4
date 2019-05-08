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

import com.via.Webservice.WebService.model.Co2;
import com.via.Webservice.WebService.service.Co2.Co2Service;

@RestController
@RequestMapping("/sep4")
public class Co2Controller {

	@Autowired
	Co2Service service;

	@GetMapping("/co2/{id}")
	public ResponseEntity<Optional<Co2>> getCo2ById(@PathVariable("id") Integer id) {
		Optional<Co2> co2 = service.findCo2ById(id);
		if (co2!=null) {
		
		return new ResponseEntity<Optional<Co2>>(co2,HttpStatus.OK);
		}
		else 
			return new ResponseEntity<Optional<Co2>>( HttpStatus.NOT_FOUND);

	}
	

	@GetMapping("/co2All")
	public ResponseEntity<Iterable<Co2>> findAllCo2() {
		Iterable<Co2> list = service.findAllCo2();
		Co2 co2 = new Co2();
		co2.add(linkTo(methodOn(Co2Controller.class).findAllCo2()).withSelfRel());
		return new ResponseEntity<Iterable<Co2>>(list, HttpStatus.OK);
		//TODO when android get all co2 it should be based on date 
		// we will publish the co2 from out database just from today 
		// then we need to give them the new data every 10 mi
		// so we need to retrieve data from our sql every 10 m (just implement the function and call it from here)

	}

}
