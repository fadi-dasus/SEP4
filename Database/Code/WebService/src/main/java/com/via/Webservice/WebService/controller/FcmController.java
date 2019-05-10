package com.via.Webservice.WebService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.via.Webservice.WebService.fcm.NotificationsService;

@RestController
@RequestMapping("/sep4/fcm")
public class FcmController {

	@Autowired
	NotificationsService androidPushNotificationsService;

	@GetMapping("/subscribe")
	public ResponseEntity<String> subscribeFCM(@RequestParam("username") String username) {
		androidPushNotificationsService.setEnabled(true);
		String msg = " This is the last record we have from our database for " + username+ " " ; 

		return new ResponseEntity<String>(msg, HttpStatus.OK);
	}
		

	
}
