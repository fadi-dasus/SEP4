package com.via.Webservice.WebService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;
import com.via.Webservice.WebService.model.Co2;
import com.via.Webservice.WebService.service.Co2Service;

@RestController
@RequestMapping("/sep4")
public class Co2Controller {

	@Autowired
	Co2Service service;

	@GetMapping("/co2/{id}")
	public ResponseEntity<Co2> getCo2ById(@PathVariable("id") Integer id) {
		Co2 co2 = service.getCo2ById(id);
		if (co2==null) {
			co2 = new Co2();
		}
		co2.add(linkTo(methodOn(Co2Controller.class).getCo2ById(id)).withSelfRel());


		return new ResponseEntity<Co2>(co2, HttpStatus.OK);

	}

	@GetMapping("/co2All")
	public ResponseEntity<List<Co2>> getCo2ById2() {
		List<Co2> list = service.getAllCo2();
		Co2 co2 = new Co2();
		co2.add(linkTo(methodOn(Co2Controller.class).getCo2ById2()).withSelfRel());
		return new ResponseEntity<List<Co2>>(list, HttpStatus.OK);

	}

}
