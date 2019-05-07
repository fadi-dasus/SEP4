package com.javasampleapproach.fcm.pushnotif.service;

import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;

import org.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class NotificationsService {
	private final String TOPIC = "MyTopic";
	private static final String FIREBASE_SERVER_KEY = "AAAADWTqU4s:APA91bFkQrNdtVcVVGMhBhYvMjPFggoYDlZzJg-1NgnHkgP4tF5oYeqxBbfn5trCN_dYkmKNsW5_ZMwQ-mGeKW3v0GmSUg7-pGl1ECQt5-mI8aFZAPI-aBSfY16LgzNsksKDPOpqgfoL";
	private static final String FIREBASE_API_URL = "https://fcm.googleapis.com/fcm/send";
	
	@Async
	public CompletableFuture<String> init(HttpEntity<String> entity) {

		RestTemplate restTemplate = new RestTemplate();

		ArrayList<ClientHttpRequestInterceptor> interceptors = new ArrayList<>();
		interceptors.add(new Interceptor("Authorization", "key=" + FIREBASE_SERVER_KEY));
		interceptors.add(new Interceptor("Content-Type", "application/json"));
		restTemplate.setInterceptors(interceptors);

		String firebaseResponse = restTemplate.postForObject(FIREBASE_API_URL, entity, String.class);

		return CompletableFuture.completedFuture(firebaseResponse);
	}
	
	@Scheduled(fixedRate = 4000)
	public void send() {

		JSONObject body = new JSONObject();
		body.put("to", "/topics/" + TOPIC);
		body.put("priority", "high");

		JSONObject notification = new JSONObject();
		notification.put("title", "My Notification");
		notification.put("body", "Happy Coding!");
		
		JSONObject data = new JSONObject();
		data.put("Key-1", "My Data 1");


		body.put("notification", notification);
		body.put("data", data);

		HttpEntity<String> request = new HttpEntity<>(body.toString());

		CompletableFuture<String> pushNotification = init(request);
		CompletableFuture.allOf(pushNotification).join();
	}
	
	
}
