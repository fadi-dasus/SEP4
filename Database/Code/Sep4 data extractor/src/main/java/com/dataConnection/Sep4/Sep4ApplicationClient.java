package com.dataConnection.Sep4;

import com.dataConnection.Sep4.SQL.Controllers.CO2Conttoller;
import com.dataConnection.Sep4.SQL.Controllers.DeviceController;
import com.dataConnection.Sep4.SQL.Controllers.HumidityController;
import com.dataConnection.Sep4.SQL.Controllers.TemperatureController;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class Sep4ApplicationClient
{
	public static void main(String[] args) {

		CO2Conttoller co2conttoller = new CO2Conttoller();
		HumidityController humidityController = new HumidityController();
		TemperatureController temperatureController = new TemperatureController();
		DeviceController deviceController = new DeviceController();

		try {
			co2conttoller.updateCO2();
			humidityController.updateHumidity();
			temperatureController.updateTemperature();
			deviceController.updateDevie();
		}catch (NullPointerException e){
			co2conttoller.loadCo2();
			humidityController.loadHumidity();
			temperatureController.loadTemperature();
			deviceController.loadDevice();
		}


	}
}
