package com.via.Webservice.WebService.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

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
import com.via.Webservice.WebService.service.RoomService;

@RestController
@RequestMapping("/sep4")
public class RoomController {
	@Autowired
	RoomService service;
	
//	@GetMapping("/room/{id}")
//	public ResponseEntity<Room> getRoomById(@PathVariable("id") Integer id) {
//		Room room = service.getRoomById(id);
//		if (room!=null) {
//		
//		
//			// room.add(linkTo(methodOn(RoomController.class).getRoomById(id)).withSelfRel());
//
//
//		return new ResponseEntity<Room>(room, HttpStatus.OK);
//		}
//		else 
//			return new ResponseEntity<>( HttpStatus.NOT_FOUND);
//
//	}

	@GetMapping("/roomAll")
	public ResponseEntity<List<Room>> getAllRoom() {
		List<Room> list = service.getAllRoom();
		Room room = new Room();
		room.add(linkTo(methodOn(RoomController.class).getAllRoom()).withSelfRel());
		return new ResponseEntity<List<Room>>(list, HttpStatus.OK);

	}

}
