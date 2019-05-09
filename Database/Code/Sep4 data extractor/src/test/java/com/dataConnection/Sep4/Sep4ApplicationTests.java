package com.dataConnection.Sep4;

import java.util.List;

import com.dataConnection.Sep4.SQL.dao.DeviceRepository;
import com.dataConnection.Sep4.SQL.dao.HumidityRepository;
import com.dataConnection.Sep4.SQL.dao.TemperatureRepository;
import com.dataConnection.Sep4.SQL.model.Device;
import com.dataConnection.Sep4.SQL.model.Humidity;
import com.dataConnection.Sep4.SQL.model.Temperature;
import com.dataConnection.Sep4.mongo.*;
import com.dataConnection.Sep4.mongo.MongoModel.EUIMongo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.test.context.junit4.SpringRunner;

import com.dataConnection.Sep4.SQL.dao.Co2Repository;
import com.dataConnection.Sep4.SQL.model.Co2;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Sep4ApplicationTests {

	@Autowired
	Co2Repository co2;

	@Autowired
	HumidityRepository humidity;

	@Autowired
	TemperatureRepository temperature;

	@Autowired
	DeviceRepository device;

	@Autowired
	EUIMongoRepository er;

	private List<EUIMongo> EUI;

	@Test
	public void loadDevice() {
		device.deleteAll();
		EUI = er.findAll();
		for(int i =0; i< EUI.size(); i++)
		{
			device.save(new Device(EUI.get(i).getName(),EUI.get(i).getUie()));
		}

		device.findAll().forEach(System.out::println);
		System.out.println("_______________________________");
	}

	@Test
	@Scheduled(fixedRate = 5000)
	public void updateDevie()
	{
		EUI = er.findAll();

		int value = EUI.size()-co2.findAll().size();

		for(int i =EUI.size()-value; i<EUI.size(); i++)
		{
			device.save(new Device(EUI.get(i).getName(),EUI.get(i).getUie()));
		}
	}

	@Test
	public void loadCo2() {
		co2.deleteAll();
		EUI = er.findAll();
		for(int i =0; i< EUI.size(); i++)
		{
			co2.save(new Co2(null,EUI.get(i).getTimestamp(),EUI.get(i).getCo2(),null));
		}

		co2.findAll().forEach(System.out::println);
		System.out.println("_______________________________");
	}

	@Test
	@Scheduled(fixedRate = 5000)
	public void updateCO2()
	{
		EUI = er.findAll();

		int value = EUI.size()-co2.findAll().size();

		for(int i =EUI.size()-value; i<EUI.size(); i++)
		{
			co2.save(new Co2(null,EUI.get(i).getTimestamp(),EUI.get(i).getCo2(),null));
		}
	}


	@Test
	public void loadHumidity() {
		humidity.deleteAll();
		EUI = er.findAll();
		for(int i =0; i< EUI.size(); i++)
		{
			humidity.save(new Humidity(null,EUI.get(i).getTimestamp(),EUI.get(i).getHumidity(),null));
		}

		humidity.findAll().forEach(System.out::println);
		System.out.println("_______________________________");
	}

	@Test
	@Scheduled(fixedRate = 5000)
	public void updateHumidity()
	{
		EUI = er.findAll();

		int value = EUI.size()-co2.findAll().size();

		for(int i =EUI.size()-value; i<EUI.size(); i++)
		{
			humidity.save(new Humidity(null,EUI.get(i).getTimestamp(),EUI.get(i).getHumidity(),null));
		}
	}

	@Test
	public void loadTemperature() {
		temperature.deleteAll();
		EUI = er.findAll();
		for(int i =0; i< EUI.size(); i++)
		{
			temperature.save(new Temperature(null,EUI.get(i).getTimestamp(),EUI.get(i).getTemperature(),null));
		}

		temperature.findAll().forEach(System.out::println);
		System.out.println("_______________________________");
	}

	@Test
	@Scheduled(fixedRate = 5000)
	public void updateTemperature()
	{
		EUI = er.findAll();

		int value = EUI.size()-co2.findAll().size();

		for(int i =EUI.size()-value; i<EUI.size(); i++)
		{
			temperature.save(new Temperature(null,EUI.get(i).getTimestamp(),EUI.get(i).getTemperature(),null));
		}
	}

}
