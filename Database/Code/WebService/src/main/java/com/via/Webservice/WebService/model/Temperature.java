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
@Table(name = "Temperature")
public class Temperature extends ResourceSupport {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id")
	private Integer Id;

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

	@Column(name = "B_ID")
	private String businessKey;
	@Column(name = "value")
	private String value;
	@Column(name = "timestamp")
	private String timestamp;

	public Temperature() {

	}

	@JsonCreator
	public Temperature(@JsonProperty("temperature") String businessKey, Room room, String value, String timestamp) {
		this.room = room;
		this.businessKey = businessKey;
		this.value = value;
		this.timestamp = timestamp;
	}

	public String getBusinessKey() {
		return businessKey;
	}

	public void setBusinessKey(String businessKey) {
		this.businessKey = businessKey;
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
		return "Temperature [Id=" + Id + ", businessKey=" + businessKey + ", value=" + value + ", timestamp="
				+ timestamp + "]";
	}

}
