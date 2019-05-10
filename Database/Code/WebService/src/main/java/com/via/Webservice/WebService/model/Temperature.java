package com.via.Webservice.WebService.model;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "Temperature")
public class Temperature extends ResourceSupport {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id")
	private int Id;

	@ManyToOne
	@JoinColumn(name="room_id")
	private Room room;

	@Column(name = "status")
	private String status;

	final transient int higheAcceptableValue = 1;

	final transient int lowAcceptableValue = 0;

	@Column(name = "value")
	private String value;
	
	@Column(name = "date")
	private LocalDate date;
	
	@Column(name = "timestamp")
	private Timestamp timestamp;

	public Temperature() {

	}

	@JsonCreator
	public Temperature(@JsonProperty("temperature") Room room, LocalDate date, String value, Timestamp timestamp) {
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

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public Timestamp getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}

	public int getHigheacceptablevalue() {
		return higheAcceptableValue;
	}

	public int getLowacceptablevalue() {
		return lowAcceptableValue;
	}
	

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Temperature [Id=" + Id + ", room=" + room + ", status=" + status + ", value=" + value + ", date=" + date
				+ ", timestamp=" + timestamp + "]";
	}

}
