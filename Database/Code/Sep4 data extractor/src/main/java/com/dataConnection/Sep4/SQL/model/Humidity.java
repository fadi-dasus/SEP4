package com.dataConnection.Sep4.SQL.model;

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



@Entity
@Table(name = "Humidity")
public class Humidity  {

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
	private double value;

	@Column(name = "date")
	private LocalDate date;

	@Column(name = "timestamp")
	private Timestamp timestamp;

	public Humidity() {

	}

	
	public Humidity( double value, LocalDate date, Timestamp timestamp, Room room) {
		this.room = room;
		this.value = value;
		this.date = date;
		this.timestamp = timestamp;
		this.status="NORMAL";
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setId(int id) {
		this.id = id;
	}



	public double getValue() {
		return value;
	}

	public void setValue(double value) {
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


	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Humidity [Id=" + id + ", room=" + room + ", status=" + status + ", value=" + value + ", date=" + date
				+ ", timestamp=" + timestamp + "]";
	}

}
