package com.dataConnection.Sep4;

import com.dataConnection.Sep4.SQL.Controllers.CO2Conttoller;
import com.dataConnection.Sep4.SQL.Controllers.DeviceController;
import com.dataConnection.Sep4.SQL.Controllers.HumidityController;
import com.dataConnection.Sep4.SQL.Controllers.TemperatureController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class Sep4ApplicationClient
{
	public static void main(String[] args) {

		SpringApplication.run(Sep4ApplicationClient.class, args);
	}
}
