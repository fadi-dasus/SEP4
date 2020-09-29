package com.via.Webservice.WebService.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.via.Webservice.WebService.model.Room;
import com.via.Webservice.WebService.service.Room.IRoomService;
import com.via.Webservice.WebService.service.Room.RoomService;

@RestController
@RequestMapping("/sep4/room")
public class RoomController {
	@Autowired
	IRoomService service;

	@GetMapping("/{id}")
	public ResponseEntity<Optional<Room>> getRoomById(@PathVariable("id") Integer id) {
		Optional<Room> room = service.getRoomById(id);
		if (room != null) {

			return new ResponseEntity<Optional<Room>>(room, HttpStatus.OK);
		} else
			return new ResponseEntity<Optional<Room>>(room, HttpStatus.NOT_FOUND);

	}

	@GetMapping("/all")
	public ResponseEntity<Iterable<Room>> getAllRoom() {
		Iterable<Room> list = service.getAllRoom();
		return new ResponseEntity<Iterable<Room>>(list, HttpStatus.OK);

	}

	@GetMapping("/name/{name}")
	public ResponseEntity<Room> getRoomByName(@PathVariable("name") String name) {
		Room room = service.getRoomByRoomName(name);
		if (room != null) {

			return new ResponseEntity<Room>(room, HttpStatus.OK);
		} else
			return new ResponseEntity<>(room, HttpStatus.NOT_FOUND);

	}

}
