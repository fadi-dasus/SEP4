#include "co2Sensor.h"

uint16_t co2_ppm_pointer;

// create drivers
void co2_sensor_init() {	
	mh_z19_create(ser_USART3, co2_callback);
}

// measuring function
void co2_measure() {
	/*TickType_t xLastWakeTimeCO2=xTaskGetTickCount();
	while(1){
		//xSemaphoreTake(*semaphore,SENSOR_TIMER*60);
		printf("CO2 TASK %d \n",xLastWakeTimeCO2);*/
	mh_z19_return_code_t rc;
	
	if ((rc = mh_z19_take_meassuring()) != MHZ19_OK) {
		printf("CO2_SENSOR_ERROR\n");
		vTaskDelay(10);
	}
		//xSemaphoreGive(*semaphore);
		//vTaskDelayUntil(&xLastWakeTimeCO2,SENSOR_TIMER*60);
	//}
}

// call back function for getting co2 value
void co2_callback(uint16_t co2_ppm) {
	co2_ppm_pointer = co2_ppm;
}


uint16_t co2_get_value() {
	return co2_ppm_pointer;
}

