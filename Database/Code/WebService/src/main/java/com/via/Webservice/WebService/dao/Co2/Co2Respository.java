package com.via.Webservice.WebService.dao.Co2;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.via.Webservice.WebService.model.Co2;
import com.via.Webservice.WebService.model.Room;

public interface Co2Respository extends CrudRepository<Co2,Integer> {
	List<Co2> findByDate(LocalDateTime date);
	List<Co2> findByRoom(Room roomid);
}
