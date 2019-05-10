package com.via.Webservice.WebService.model;

import java.sql.Timestamp;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
	private int id;

	@ManyToOne
	@JoinColumn(name = "room_id")
	private Room room;

	@Column(name = "status")
	private String status;

	@Column(name = "value")
	private String value;

	@Column(name = "date")
	private LocalDate date;

	@Column(name = "timestamp")
	private Timestamp timestamp;

	public Temperature() {

	}

	@JsonCreator
	public Temperature(@JsonProperty("temperature") String value, Room room, LocalDate date, Timestamp timestamp) {
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

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Temperature [Id=" + id + ", room=" + room + ", status=" + status + ", value=" + value + ", date=" + date
				+ ", timestamp=" + timestamp + "]";
	}

}
