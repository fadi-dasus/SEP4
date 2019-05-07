package com.via.Webservice.WebService.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "Room")
public class Room extends ResourceSupport {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id")
	private int Id;

	@Column(name = "roomName")
	private String roomName;

	@OneToOne
	private Device device;

	public Room() {

	}

	@JsonCreator
	public Room(@JsonProperty("room") String roomName) {
		this.roomName = roomName;
	}

	public String getRoomName() {
		return roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public Device getDevice() {
		return device;
	}


	public void setDevice(Device device) {
		this.device = device;
	}
	@Override
	public String toString() {
		return "Room [Id=" + Id + ", roomName=" + roomName + ", device=" + device + "]";
	}

}
