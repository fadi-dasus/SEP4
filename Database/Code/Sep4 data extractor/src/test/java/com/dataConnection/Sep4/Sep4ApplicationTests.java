package com.dataConnection.Sep4;

import java.util.List;

import com.dataConnection.Sep4.SQL.dao.HumidityRepository;
import com.dataConnection.Sep4.SQL.dao.TemperatureRepository;
import com.dataConnection.Sep4.SQL.model.Humidity;
import com.dataConnection.Sep4.SQL.model.Temperature;
import com.dataConnection.Sep4.mongo.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.dataConnection.Sep4.SQL.dao.Co2Repository;
import com.dataConnection.Sep4.SQL.model.Co2;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Sep4ApplicationTests {

	@Autowired
	Co2Repository co2;

	@Autowired
	RoomRepository rr;

	@Autowired
	Co2MongoRepository cr;

	@Autowired
	HumidityRepository humidity;

	@Autowired
	HumidityMongoRepository hr;

	@Autowired
	TemperatureRepository temperature;

	@Autowired
	TemperatureMongoRepository tr;




	@Test
	public void loadCo2() {
		co2.deleteAll();
		List<Co2Mongo> list = cr.findAll();

		for(int i =0; i< list.size(); i++)
		{
			co2.save(new Co2(list.get(i).getId().getDate(),list.get(i).getPpm()));
		}

		co2.findAll().forEach(System.out::println);
		System.out.println("_______________________________");
	}

	@Test
	public void loadHumidity() {
		humidity.deleteAll();
		List<HumidityMongo> list = hr.findAll();

		for(int i =0; i< list.size(); i++)
		{
			humidity.save(new Humidity(list.get(i).getId().getDate(),list.get(i).getPercentage()));
		}

		humidity.findAll().forEach(System.out::println);
		System.out.println("_______________________________");
	}

	@Test
	public void loadTemperature() {
		temperature.deleteAll();
		List<TemperatureMongo> list = tr.findAll();

		for(int i =0; i< list.size(); i++)
		{
			temperature.save(new Temperature(list.get(i).getId().getDate(),list.get(i).getTempInC()));
		}

		temperature.findAll().forEach(System.out::println);
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
