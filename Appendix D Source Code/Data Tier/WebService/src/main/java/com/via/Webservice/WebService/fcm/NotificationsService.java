package com.via.Webservice.WebService.fcm;

import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.via.Webservice.WebService.dao.Co2.Co2Respository;
import com.via.Webservice.WebService.dao.Humidity.HumidityRepository;
import com.via.Webservice.WebService.dao.Room.RoomRepository;
import com.via.Webservice.WebService.dao.Temperature.TemperatureRepository;
import com.via.Webservice.WebService.model.Co2;
import com.via.Webservice.WebService.model.Humidity;
import com.via.Webservice.WebService.model.Room;
import com.via.Webservice.WebService.model.Temperature;

@Service
public class NotificationsService {
	
	private String topic;
	private Room room;
	
	
	
	
	@Value("${jobs.enabled:false}")
	private boolean isEnabled;
	@Autowired
	Co2Respository co2Respository;
	@Autowired
	TemperatureRepository temperatureRepository;
	@Autowired
	HumidityRepository humidityRespository;
	@Autowired
	RoomRepository roomRepository;	
	//private static final String FIREBASE_SERVER_KEY = "AAAADWTqU4s:APA91bFkQrNdtVcVVGMhBhYvMjPFggoYDlZzJg-1NgnHkgP4tF5oYeqxBbfn5trCN_dYkmKNsW5_ZMwQ-mGeKW3v0GmSUg7-pGl1ECQt5-mI8aFZAPI-aBSfY16LgzNsksKDPOpqgfoL";
	private static final String FIREBASE_SERVER_KEY = "AAAAbmqSls4:APA91bEq9UgyryzDjfaqEUDMvyAEZJq6E3K143Mup8p1gzXzJABbEBnMKYAqVDsU9zIio1dLkMMNDXfaZHI6xRIe6HzDmepCk8YwkzNxr4GT61HynCP-BfPpeafezVkgX40QLb8ntrC9";
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

	@Scheduled(fixedDelay = 1000,initialDelay = 6000)
	@Async
	public void send() {

		if (isEnabled) {
			DTObject dto = getDataForTheTopic();
			if (dto != null) {

				JSONObject body = new JSONObject();
				body.put("to", "/topics/" + topic);
				body.put("priority", "high");

				JSONObject data = new JSONObject();
				data.put("co2_value", dto.getCo2());
				data.put("hum_value", dto.getHumidity());
				data.put("temp_value", dto.getTemperature());
				data.put("timestamp", dto.getTime().toString());
				data.put("topic", this.topic);

				body.put("data", data);

				HttpEntity<String> request = new HttpEntity<>(body.toString());

				CompletableFuture<String> pushNotification = init(request);
				CompletableFuture.allOf(pushNotification).join();
			}
		}
	}

	public void setEnabled(boolean isEnabled) {
		this.isEnabled = isEnabled;
	}

	@Async
	public DTObject getDataForTheTopic() {
		Co2 co2 = co2Respository.findTopByRoomOrderByIdDesc(this.room);
		Temperature temperature = temperatureRepository.findTopByRoomOrderByIdDesc(this.room);
		Humidity humidity = humidityRespository.findTopByRoomOrderByIdDesc(this.room);
		if (co2 != null && temperature != null && humidity != null) {
			DTObject dto = new DTObject(co2.getValue(), temperature.getValue(), humidity.getValue(),
					co2.getTimestamp());
			System.out.println(dto.toString());
			return dto;
		}

		return null;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public boolean isEnabled() {
		return isEnabled;
	}

}
