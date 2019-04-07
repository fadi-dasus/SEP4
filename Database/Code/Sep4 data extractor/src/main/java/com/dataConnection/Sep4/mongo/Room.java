package com.dataConnection.Sep4.mongo;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "rooms")
@TypeAlias("room")
public class Room {

	@Field("roomNumber")
	@Indexed(name = "roomNumber", unique = true)
	private String roomNumber;
	@Id
	private ObjectId _id;
	@DBRef
	private Co2Mongo co2;

	public Room() {
	}

	@PersistenceConstructor
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
