package com.javasampleapproach.fcm.pushnotif.controller;

import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javasampleapproach.fcm.pushnotif.service.NotificationsService;

@RestController
@RequestMapping("/test")
public class WebController {

	

	@Autowired
	NotificationsService androidPushNotificationsService;

	@GetMapping("/job")
	public void send() throws JSONException {
		androidPushNotificationsService.setEnabled(true);
		

	}
}
