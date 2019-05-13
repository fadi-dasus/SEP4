package com.example.sensorsproject.business.models;

import com.google.gson.annotations.SerializedName;

public class MyRoom {

	@SerializedName("roomName")
	private String roomName;
	private String id;

	public MyRoom(String roomName, String id) {
		this.roomName = roomName;
		this.id = id;
	}

	public String getRoomName() {
		return roomName;
	}

	public String getId() {
		return id;
	}

	@Override
	public String toString() {
		return roomName;
	}
}
