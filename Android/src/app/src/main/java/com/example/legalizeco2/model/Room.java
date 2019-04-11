package com.example.legalizeco2.model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Room_table")
public class Room {

	@PrimaryKey
	@NonNull
	@ColumnInfo(name = "room")

	private int ID;

	private String roomName;

	public Room() {

	}

	public Room(int iD, String roomName) {

		ID = iD;
		this.roomName = roomName;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getRoomName() {
		return roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}

}
