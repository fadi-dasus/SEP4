package com.dataConnection.Sep4.SQL.model;

import org.bson.types.BSONTimestamp;
import org.bson.types.ObjectId;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;


@Entity
@Table(name = "Co2")
public class Co2 {

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

	public Co2(){

	}


	public Co2(String status, Date date, String value,  Room room) {
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
		return "Co2{" +
				"status='" + status + '\'' +
				", date=" + date +
				", value='" + value + '\'' +
				", room=" + room +
				'}';
	}
}