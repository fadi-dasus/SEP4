package com.dataConnection.Sep4.SQL.model;


import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "Humidity")
public class Humidity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Id")
	private int id;

	@ManyToOne
	private Room room;

	@Column(name = "status")
	private String status;

	@Column(name = "value")
	private String value;

	@Column(name = "Timestamp")
	private Date date;

	public Humidity(){

	}


	public Humidity(String status, Date date, String value,  Room room) {
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

	public int getId() { return id; }

	public void setId(int id) { this.id = id; }

	public Date getDate() { return date; }

	public void setDate(Date date) { this.date = date; }

	@Override
	public String toString() {
		return "Humidity{" +
				"status='" + status + '\'' +
				", date=" + date +
				", value='" + value + '\'' +
				", room=" + room +
				'}';
	}
}