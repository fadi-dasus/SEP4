package com.javasampleapproach.fcm.pushnotif.controller;

import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.javasampleapproach.fcm.pushnotif.service.NotificationsService;

@RestController
public class WebController {

	

	@Autowired
	NotificationsService androidPushNotificationsService;

	@RequestMapping(value = "/send", method = RequestMethod.GET, produces = "application/json")
	public void send() throws JSONException {
		androidPushNotificationsService.send();

	}
}
