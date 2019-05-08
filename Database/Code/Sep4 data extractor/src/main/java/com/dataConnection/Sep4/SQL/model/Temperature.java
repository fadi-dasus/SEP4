package com.dataConnection.Sep4.SQL.model;

import org.bson.types.ObjectId;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "temperature")
public class Temperature {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;

	@Column(name = "status")
	private String status;

	@Column(name = "timestamp")
	private Date date;

	@Column(name = "value")
	private String value;

	@Column(name = "room")
	private int room;

	public Temperature(){

	}

	public Temperature(String status, Date date, String value, int room) {
		this.status = status;
		this.date = date;
		this.value = value;
		this.room = room;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public int getRoom() {
		return room;
	}

	public void setRoom(int room) {
		this.room = room;
	}

	@Override
	public String toString() {
		return "Temperature{" +
				"status='" + status + '\'' +
				", date=" + date +
				", value='" + value + '\'' +
				", room=" + room +
				'}';
	}
}