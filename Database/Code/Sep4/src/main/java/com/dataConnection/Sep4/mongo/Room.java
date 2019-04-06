package com.dataConnection.Sep4.mongo;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "rooms")
public class Room {
	
	private String roomNumber;
	@Id
	private ObjectId _id;

	public Room() {
	}

	public Room(String roomNumber) {
		
		this.roomNumber = roomNumber;
		
	}

	public String getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}

	public ObjectId getId() {
		return _id;
	}

	public void setId(ObjectId id) {
		this._id = id;
	}
	
	@Override
	public String toString() {
		return "Room [roomNumber=" + roomNumber + ", _id=" + _id + "]";
	}


}
