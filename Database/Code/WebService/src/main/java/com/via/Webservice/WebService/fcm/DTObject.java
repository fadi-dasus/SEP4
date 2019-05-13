package com.via.Webservice.WebService.fcm;

import java.sql.Timestamp;

public class DTObject {

	private String co2;
	private String humidity;
	private String temperature;
	private Timestamp time;



	public DTObject(String co2, String humidity, String temperature,Timestamp time) {

		this.co2 = co2;
		this.humidity = humidity;
		this.temperature = temperature;
		this.time = time;
	}

	public DTObject() {

	}

	public String getCo2() {
		return co2;
	}

	public void setCo2(String co2) {
		this.co2 = co2;
	}

	public String getHumidity() {
		return humidity;
	}

	public void setHumidity(String humidity) {
		this.humidity = humidity;
	}

	public String getTemperature() {
		return temperature;
	}

	public void setTemperature(String temperature) {
		this.temperature = temperature;
	}
	
	public Timestamp getTime() {
		return time;
	}

	public void setTime(Timestamp time) {
		this.time = time;
	}

	@Override
	public String toString() {
		return "DTObject [co2=" + co2 + ", humidity=" + humidity + ", temperature=" + temperature + "]";
	}

}
