
/*
 * temp_humSensors.c
 *
 * Created: 07/05/2019 13.41.02
 *  Author: Roza
 */ 

#include "temp_humSensor.h"
float hum = 0.0;
float temp = 0.0;

// create drivers
void temp_hum_sensor_init() 
{	
	if ( HIH8120_OK == hih8120Create() )
	{
		printf("temp_hum_sensor_created \n");
	}
}

// measuring function
void temp_hum_measure() {
	
	
	
	if ( HIH8120_OK != hih8120Wakeup() )
	{
		printf("temp_hum_SENSOR_ERROR\n");
	}
	if ( HIH8120_OK !=  hih8120Meassure() )
	{
		printf("temp_hum_SENSOR_ERROR1\n");
	}
		
}




float temp_get_value() {
	 temp = hih8120GetTemperature();
	return temp;
}

float hum_get_value() {
	 hum= hih8120GetHumidity();
	return hum;
}
