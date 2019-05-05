package com.via.Webservice.WebService.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "Warning")
public class Warning extends ResourceSupport{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id")
	private Integer Id;
	@Column(name = "MeasurementType")
	private String MeasurementType;
	@Column(name = "timeStamp")
	private String timeStamp;
	@Column(name = "high")
	private boolean high;
	@Column(name = "low")
	private boolean low;
	@Column(name = "value")
	private double value;
	@Column(name = "roomName")
	private String roomName;

	@JsonCreator
	public Warning(@JsonProperty("warning") String measurementType, String timeStamp, boolean high, boolean low, double value, String roomName) {

		MeasurementType = measurementType;
		this.timeStamp = timeStamp;
		this.high = high;
		this.low = low;
		this.value = value;
		this.roomName = roomName;
	}

	public Warning() {

	}

	public String getMeasurementType() {
		return MeasurementType;
	}

	public void setMeasurementType(String measurementType) {
		MeasurementType = measurementType;
	}

	public String getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}

	public boolean isHigh() {
		return high;
	}

	public void setHigh(boolean high) {
		this.high = high;
	}

	public boolean isLow() {
		return low;
	}

	public void setLow(boolean low) {
		this.low = low;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public String getRoomName() {
		return roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}

	@Override
	public String toString() {
		return "Warning [Id=" + Id + ", MeasurementType=" + MeasurementType + ", timeStamp=" + timeStamp + ", high="
				+ high + ", low=" + low + ", value=" + value + ", roomName=" + roomName + "]";
	}

}
