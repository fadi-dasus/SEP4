package com.dataConnection.Sep4;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.dataConnection.Sep4.SQL.dao.Co2Repository;
import com.dataConnection.Sep4.SQL.model.Co2;
import com.dataConnection.Sep4.mongo.Room;
import com.dataConnection.Sep4.mongo.RoomRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Sep4ApplicationTests {

	@Autowired
	Co2Repository co2;

	@Autowired
	RoomRepository rr;

	@Test
	public void contextLoads() {
		co2.deleteAll();
		co2.save(new Co2("14ppm"));
		co2.save(new Co2("15ppm"));
		co2.save(new Co2("16ppm"));
		co2.findAll().forEach(System.out::println);
		System.out.println("_______________________________");

	}

	@Test
	public void contextLoadsMongo() {
//		rr.insert(new Room("100001"));
		Room room = rr.findByRoomNumber("100001");
		System.out.println("_______________________________");
		System.out.println(room.toString());

		System.out.println("_______________________________");
		System.out.println("______________extracting date from objectid_________");

		System.out.println(room.getId().getDate());
		System.out.println("_______________________________");

		System.out.println("_______________________________");
		List<Room> roms = rr.findAll();
		for (Room room2 : roms) {
			System.out.println(" this is the room from the list ");
			System.out.println(room2.toString());
			System.out.println("_______________________________");
		}

		rr.findAll().forEach(System.out::println);

	}
}
