package com.via.Webservice.WebService.controller;

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
@RequestMapping("/sep4/fcm")
public class FcmController {

	@Autowired
	Co2Service service;

	@GetMapping("/subscribe/{topic}")
	public ResponseEntity<String> subscribeFCM(@PathVariable("topic") String topic) {
		

		Co2 co2 = service.getTopByOrderByIdDescAndRoom(topic);
		if (co2 != null) {
			String msg = " The last record we have from our database for " + topic + " recorded at : "
					+ co2.getDate().toString();

			return new ResponseEntity<String>(msg, HttpStatus.OK);
		} else
			return new ResponseEntity<String>("sorry we do not have data for this room", HttpStatus.NOT_ACCEPTABLE);
	}

}
