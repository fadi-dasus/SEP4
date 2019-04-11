package com.example.legalizeco2.business.model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "room_table")
public class Room {

	@PrimaryKey(autoGenerate = true)
	@NonNull
	private int id;

	private String roomName;

	public Room() {

	}

	public Room(int id, String roomName) {

		this.id = id;
		this.roomName = roomName;
	}

	public int getID() {
		return this.id;
	}

	public void setID(int id) {
		this.id = id;
	}

	public String getRoomName() {
		return roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}

}
