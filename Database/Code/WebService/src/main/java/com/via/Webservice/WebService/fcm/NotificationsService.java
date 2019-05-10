package com.via.Webservice.WebService.fcm;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class NotificationsService {
	
	@Value("${jobs.enabled:false}")
	  private boolean isEnabled;
	
	
	

	private final String TOPIC = "MyTopic";

//	private final String TOPIC = "E303";
	// this is my key for my android app
	private static final String FIREBASE_SERVER_KEY = "AAAADWTqU4s:APA91bFkQrNdtVcVVGMhBhYvMjPFggoYDlZzJg-1NgnHkgP4tF5oYeqxBbfn5trCN_dYkmKNsW5_ZMwQ-mGeKW3v0GmSUg7-pGl1ECQt5-mI8aFZAPI-aBSfY16LgzNsksKDPOpqgfoL";
	
	// this is Ainis server key
	//private static final String FIREBASE_SERVER_KEY = "AAAAbmqSls4:APA91bEq9UgyryzDjfaqEUDMvyAEZJq6E3K143Mup8p1gzXzJABbEBnMKYAqVDsU9zIio1dLkMMNDXfaZHI6xRIe6HzDmepCk8YwkzNxr4GT61HynCP-BfPpeafezVkgX40QLb8ntrC9";

	
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
	
	@Scheduled(fixedRate = 1000)
	public void send() {
		 DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		   LocalDateTime now = LocalDateTime.now(); 
		  String time =  dtf.format(now);
		   
		 if(isEnabled) {
		JSONObject body = new JSONObject();
		body.put("to", "/topics/" + TOPIC);
		body.put("priority", "high");
	
		JSONObject data = new JSONObject();
		data.put("co2_value", "1050" );
		data.put("hum_value", "20");
		data.put("temp_value", "30");
		data.put("timestamp", time);

		body.put("data", data);

		HttpEntity<String> request = new HttpEntity<>(body.toString());

		CompletableFuture<String> pushNotification = init(request);
		CompletableFuture.allOf(pushNotification).join();
	}
	}
	
	public boolean isEnabled() {
		return isEnabled;
	}

	public void setEnabled(boolean isEnabled) {
		this.isEnabled = isEnabled;
	}
	
	
}
