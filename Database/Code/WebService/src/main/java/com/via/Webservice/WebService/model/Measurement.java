package com.via.Webservice.WebService.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.hateoas.ResourceSupport;

@Entity
@Table(name = "Measurement")
public class Measurement extends ResourceSupport {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Id")
	private Integer Id;

	@ManyToOne
	@JoinColumn(name = "co2_ID")
	private Co2 co2;
	@ManyToOne
	@JoinColumn(name = "humidity_ID")
	private Humidity humidity;
	@ManyToOne
	@JoinColumn(name = "temperature_ID")
	private Temperature temperature;
	@ManyToOne
	@JoinColumn(name = "room_ID")
	private Room room;
	
	public Measurement() {
		super();
	}

	public Co2 getCo2() {
		return co2;
	}

	public void setCo2(Co2 co2) {
		this.co2 = co2;
	}

	public Humidity getHumidity() {
		return humidity;
	}

	public void setHumidity(Humidity humidity) {
		this.humidity = humidity;
	}

	public Temperature getTemperature() {
		return temperature;
	}

	public void setTemperature(Temperature temperature) {
		this.temperature = temperature;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}
}
