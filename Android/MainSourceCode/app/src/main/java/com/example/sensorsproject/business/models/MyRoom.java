package com.example.sensorsproject.business.models;

import com.google.gson.annotations.SerializedName;

public class MyRoom {

	@SerializedName("room")
	private String roomName;

	public MyRoom(String roomName) {

		this.roomName = roomName;
	}

	public String getRoomName() {
		return roomName;
	}

	@Override
	public String toString() {
		return roomName;
	}
}
