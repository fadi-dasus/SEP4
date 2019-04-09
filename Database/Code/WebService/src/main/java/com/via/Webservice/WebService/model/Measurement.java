package com.via.Webservice.WebService.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Measurement")
public class Measurement {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

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

}
