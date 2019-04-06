package com.dataConnection.Sep4;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.dataConnection.Sep4.SQL.dao.Co2Repository;
import com.dataConnection.Sep4.SQL.model.Co2;
import com.dataConnection.Sep4.mongo.Room;
import com.dataConnection.Sep4.mongo.RoomRepository;

import ch.qos.logback.core.net.SyslogOutputStream;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Sep4ApplicationTests {

	@Autowired
	Co2Repository co2;

	@Autowired
	RoomRepository rr;

	@Test
	public void contextLoads() {
		co2.save(new Co2("14ppm"));
		co2.save(new Co2("15ppm"));
		co2.save(new Co2("16ppm"));
		co2.findAll().forEach(System.out::println);
		;

	}

	@Test
	public void contextLoadsMongo() {
		rr.insert(new Room("10000"));

		rr.findAll().forEach(System.out::println);
		;

	}
}
