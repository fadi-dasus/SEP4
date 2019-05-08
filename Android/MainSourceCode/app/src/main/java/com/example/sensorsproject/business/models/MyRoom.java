package com.example.sensorsproject.business.models;

public class MyRoom {

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
