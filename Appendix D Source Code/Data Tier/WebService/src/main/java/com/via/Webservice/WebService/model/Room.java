package com.via.Webservice.WebService.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Room")
public class Room {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id")
	private int id;

	@Column(name = "roomName")
	private String roomName;

	@OneToOne
	private Device device;

	public Room() {

	}

	public Room(int id) {
		this.id = id;
	}

	
	public Room(int id, String roomName, Device device) {
		this.roomName = roomName;
		this.device=device;
		this.id=id;
	}

	public String getRoomName() {
		return roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}

	public void setId(Integer id) {
		id = id;
	}


	public Device getDevice() {
		return device;
	}

	public void setDevice(Device device) {
		this.device = device;
	}
	

	public int getId() {
		return id;
	}

	

	@Override
	public String toString() {
		return "Room [Id=" + id + ", roomName=" + roomName + ", device=" + device + "]";
	}

}
