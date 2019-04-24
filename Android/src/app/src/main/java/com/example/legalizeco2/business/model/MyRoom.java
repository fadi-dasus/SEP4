package com.example.legalizeco2.business.model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "room_table")
public class MyRoom {

	@PrimaryKey(autoGenerate = true)
	@NonNull
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
		return "MyRoom{" +
				"id=" + id +
				", roomName='" + roomName + '\'' +
				'}';
	}
}
