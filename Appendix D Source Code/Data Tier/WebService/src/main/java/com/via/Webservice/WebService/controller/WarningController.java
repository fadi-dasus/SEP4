package com.via.Webservice.WebService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.via.Webservice.WebService.model.Room;
import com.via.Webservice.WebService.model.Warning;
import com.via.Webservice.WebService.service.Warning.IWarningService;

@RestController
@RequestMapping("/sep4/warning")
public class WarningController {
	@Autowired
	IWarningService service;

	@GetMapping("/room/{id}")
	public ResponseEntity<Iterable<Warning>> getAllWarnings(@PathVariable("id") int id) {
		Room room = new Room(id);
		Iterable<Warning> list = service.getAllWarningByRoomId(room);
		return new ResponseEntity<Iterable<Warning>>(list, HttpStatus.OK);

	}

}
