package com.via.Webservice.WebService.model;

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

	@Column(name = "timeStamp")
	private LocalDate localDate;

	@Column(name = "value")
	private double value;

	@ManyToOne
	private Room room;

	@Column(name = "status")
	private String status;

	public Warning() {

	}

	
	public Warning(Integer id, String measurementType, LocalDate localDate, double value,
			Room room) {

		id = id;
		MeasurementType = measurementType;
		this.localDate = localDate;

		this.value = value;
		this.room = room;

	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setId(int id) {
		id = id;
	}

	public String getMeasurementType() {
		return MeasurementType;
	}

	public void setMeasurementType(String measurementType) {
		MeasurementType = measurementType;
	}


	public LocalDate getLocalDate() {
		return localDate;
	}

	public void setLocalDate(LocalDate localDate) {
		this.localDate = localDate;
	}

	public int getId() {
		return id;
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

	@Override
	public String toString() {
		return "Warning [Id=" + id + ", MeasurementType=" + MeasurementType + ", timeStamp=" + localDate + ", value="
				+ value + ", room=" + room + ", status=" + status + "]";
	}

}
