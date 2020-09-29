package com.via.Webservice.WebService.service.Warning;

import com.via.Webservice.WebService.model.Room;
import com.via.Webservice.WebService.model.Warning;

public interface IWarningService {
	public Iterable<Warning> getAllWarningByRoomId(Room room);
}
