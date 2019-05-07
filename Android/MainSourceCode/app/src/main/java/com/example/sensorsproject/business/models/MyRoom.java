package com.example.sensorsproject.business.models;

public class MyRoom {

	private int id;

	private String roomName;

	public MyRoom(int id, String roomName) {

		this.id = id;
		this.roomName = roomName;
	}

	public int getId() {
		return id;
	}

	public String getRoomName() {
		return roomName;
	}

	@Override
	public String toString() {
		return roomName + " " + id;
	}
}
