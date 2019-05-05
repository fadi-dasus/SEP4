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

import com.via.Webservice.WebService.model.Warning;
import com.via.Webservice.WebService.service.WarningService;

@RestController
@RequestMapping("/sep4")
public class WarningController {
	@Autowired
	WarningService service;
	
	@GetMapping("/warningAll")
	public ResponseEntity<List<Warning>> getAllWarnings() {
		List<Warning> list = service.getAllWarning();
		Warning warning = new Warning();
		warning.add(linkTo(methodOn(WarningController.class).getAllWarnings()).withSelfRel());
		return new ResponseEntity<List<Warning>>(list, HttpStatus.OK);

	}

}
