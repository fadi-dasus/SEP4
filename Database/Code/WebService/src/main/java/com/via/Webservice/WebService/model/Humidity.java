package com.via.Webservice.WebService.model;

import java.sql.Timestamp;

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
	@Column(name = "Id")
	private int Id;
	@ManyToOne
	private Room room;

	@Column(name = "status")
	private String status;

	final transient int higheAcceptableValue = 1;

	final transient int lowAcceptableValue = 0;

	@Column(name = "value")
	private String value;

	@Column(name = "timestamp")
	private Timestamp timestamp;

	public Humidity() {

	}

	@JsonCreator
	public Humidity(@JsonProperty("humidity") String value, Timestamp timestamp, Room room) {
		this.room = room;

		this.value = value;
		this.timestamp = timestamp;
	}
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}


	public void setId(int id) {
		this.Id = id;
	}
	
	public int getHigheAcceptableValue() {
		return higheAcceptableValue;
	}

	public int getLowAcceptableValue() {
		return lowAcceptableValue;
	}
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Timestamp getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public int getHigheacceptablevalue() {
		return higheAcceptableValue;
	}

	public int getLowacceptablevalue() {
		return lowAcceptableValue;
	}

	@Override
	public String toString() {
		return "Humidity [Id=" + Id + ", room=" + room + ", status=" + status + ", higheAcceptableValue="
				+ higheAcceptableValue + ", lowAcceptableValue=" + lowAcceptableValue + ", value=" + value
				+ ", timestamp=" + timestamp + "]";
	}

	

}
