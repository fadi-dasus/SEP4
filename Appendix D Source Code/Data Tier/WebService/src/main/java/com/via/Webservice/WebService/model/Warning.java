package com.via.Webservice.WebService.model;

import java.sql.Timestamp;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Warning")
public class Warning {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id")
	private int id;

	@Column(name = "MeasurementType")
	private String MeasurementType;

	@Column(name = "date")
	private LocalDate date;

	@Column(name = "timestamp")
	private Timestamp timestamp;

	@Column(name = "value")
	private double value;

	@ManyToOne
	private Room room;

	@Column(name = "status")
	private String status;

	public Warning() {

	}

	public Warning(int id, String measurementType, LocalDate date, Timestamp timestamp, double value, Room room,
			String status) {
		super();
		this.id = id;
		MeasurementType = measurementType;
		this.date = date;
		this.timestamp = timestamp;
		this.value = value;
		this.room = room;
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMeasurementType() {
		return MeasurementType;
	}

	public void setMeasurementType(String measurementType) {
		MeasurementType = measurementType;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public Timestamp getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Warning [id=" + id + ", MeasurementType=" + MeasurementType + ", date=" + date + ", timestamp="
				+ timestamp + ", value=" + value + ", room=" + room + ", status=" + status + "]";
	}

	

}
