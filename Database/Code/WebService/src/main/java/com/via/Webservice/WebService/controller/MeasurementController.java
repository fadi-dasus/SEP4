package com.via.Webservice.WebService.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.via.Webservice.WebService.model.Measurement;
import com.via.Webservice.WebService.service.MeasurementService;
@RestController
@RequestMapping("/sep4")
public class MeasurementController {
	@Autowired
	MeasurementService service;
	@GetMapping("/measurementAll")
	public ResponseEntity<List<Measurement>> getAllMeasurement() {
		List<Measurement> list = service.getAllMeasurement();
		Measurement measurement = new Measurement();
		measurement.add(linkTo(methodOn(MeasurementController.class).getAllMeasurement()).withSelfRel());
		return new ResponseEntity<List<Measurement>>(list, HttpStatus.OK);

	}
}
