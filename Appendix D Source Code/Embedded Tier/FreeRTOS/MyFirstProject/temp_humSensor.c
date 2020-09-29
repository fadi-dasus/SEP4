
/*
 * temp_humSensors.c
 *
 * Created: 07/05/2019 13.41.02
 *  Author: Roza
 */ 

#include "temp_humSensor.h"

static int temp_rc;

// create drivers
void temp_hum_sensor_init() 
{	

	if ( HIH8120_OK == ( temp_rc = hih8120Create()) )
	{
		printf("temp_hum_sensor_created \n");
	}
}

// measuring function
void temp_hum_measure() {
	
	hih8120DriverReturnCode_t rc;


	/*while(!hih8120IsReady()){
		printf("not ready");
		vTaskDelay(1000/portTICK_PERIOD_MS);
	}*/
	//printf("temp sensor -> %d", temp_rc);
	vTaskDelay(1000/portTICK_PERIOD_MS);
	if ( HIH8120_OK != ( rc = hih8120Wakeup() ))
	{
		printf("temp_hum_SENSOR_ERROR --> %d", rc);
	}
	//printf("temp_hum_rc --> %d", rc);
	vTaskDelay(50/portTICK_PERIOD_MS);
	if ( HIH8120_OK != ( rc = hih8120Meassure()) )
	{
		printf("temp_hum_SENSOR_ERROR1 --> %d", rc);
	}
	//printf("temp_hum_rc --> %d", rc);
	vTaskDelay(1000/portTICK_PERIOD_MS);
		
}




uint16_t temp_get_value() {
	return hih8120GetTemperature_x10();
}

uint16_t hum_get_value() {
	return hih8120GetHumidityPercent_x10();
}
