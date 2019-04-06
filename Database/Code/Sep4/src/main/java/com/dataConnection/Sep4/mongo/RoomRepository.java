package com.dataConnection.Sep4.mongo;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;



public interface RoomRepository extends MongoRepository<Room, String> {
	Room findBy_id(String string);
	Room findByRoomNumber(String number);
}
