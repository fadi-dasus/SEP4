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
@Table(name = "Warning")
public class Warning extends ResourceSupport {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id")
	private int Id;

	@Column(name = "MeasurementType")
	private String MeasurementType;

	@Column(name = "timeStamp")
	private Timestamp timeStamp;

	@Column(name = "value")
	private double value;

	@ManyToOne
	private Room room;

	@Column(name = "status")
	private String status;

	public Warning() {

	}

	@JsonCreator
	public Warning(@JsonProperty("warning") Integer id, String measurementType, Timestamp timeStamp, double value,
			Room room) {

		Id = id;
		MeasurementType = measurementType;
		this.timeStamp = timeStamp;

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
		Id = id;
	}

	public String getMeasurementType() {
		return MeasurementType;
	}

	public void setMeasurementType(String measurementType) {
		MeasurementType = measurementType;
	}

	public Timestamp getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Timestamp timeStamp) {
		this.timeStamp = timeStamp;
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
		return "Warning [Id=" + Id + ", MeasurementType=" + MeasurementType + ", timeStamp=" + timeStamp + ", value="
				+ value + ", room=" + room + ", status=" + status + "]";
	}

}
