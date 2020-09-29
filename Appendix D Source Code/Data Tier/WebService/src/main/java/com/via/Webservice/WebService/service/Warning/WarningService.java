package com.via.Webservice.WebService.service.Warning;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.via.Webservice.WebService.dao.Warning.WarningRepository;
import com.via.Webservice.WebService.model.Room;
import com.via.Webservice.WebService.model.Warning;

@Service
public class WarningService implements IWarningService {

	@Autowired
	WarningRepository dao;

	@Override
	public Iterable<Warning> getAllWarningByRoomId(Room room) {

		return dao.findByRoom(room);
	}
}
