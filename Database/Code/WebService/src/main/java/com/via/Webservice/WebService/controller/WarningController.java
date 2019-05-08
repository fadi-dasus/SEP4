package com.via.Webservice.WebService.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.via.Webservice.WebService.model.Warning;
import com.via.Webservice.WebService.service.Warning.WarningService;

@RestController
@RequestMapping("/sep4")
public class WarningController {
	@Autowired
	WarningService service;
	
	@GetMapping("/warningAll")
	public ResponseEntity<Iterable<Warning>> findAllWarnings() {
		Iterable<Warning> list = service.findAllWarning();
		Warning warning = new Warning();
		warning.add(linkTo(methodOn(WarningController.class).findAllWarnings()).withSelfRel());
		return new ResponseEntity<Iterable<Warning>>(list, HttpStatus.OK);
		

	}

}
