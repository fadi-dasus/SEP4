package com.via.Webservice.WebService.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "Humidity")
public class Humidity extends ResourceSupport {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "H_Id")
	private Integer H_Id;
	@ManyToOne
	private Room room;
	
	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}
	

	static final transient String higheAcceptableValue = "some value ";

	static final transient String lowAcceptableValue = "another value ";

	@Column(name = "Humidity_ID")
	private String Humidity_ID;
	@Column(name = "value")
	private String value;
	@Column(name = "timestamp")
	private String timestamp;

	public Humidity() {

	}

	@JsonCreator
	public Humidity(@JsonProperty("humidity") String businessKey, String value, String timestamp,Room room) {
		this.room = room;
		this.Humidity_ID = businessKey;
		this.value = value;
		this.timestamp = timestamp;
	}

	public String getBusinessKey() {
		return Humidity_ID;
	}

	public void setBusinessKey(String businessKey) {
		this.Humidity_ID = businessKey;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public static String getHigheacceptablevalue() {
		return higheAcceptableValue;
	}

	public static String getLowacceptablevalue() {
		return lowAcceptableValue;
	}

	@Override
	public String toString() {
		return "Humidity [Id=" + H_Id + ", businessKey=" + Humidity_ID + ", value=" + value + ", timestamp=" + timestamp
				+ "]";
	}

}
