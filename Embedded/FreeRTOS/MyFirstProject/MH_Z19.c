#include "MH_Z19.h"

static uint16_t CO2_value_ppm;
int const CO2_Timer=1000/portTICK_PERIOD_MS;



void my_co2_call_back(uint16_t CO2_ppm)
{
	CO2_value_ppm = CO2_ppm; 
	printf(" %d CO2 value: ", *private CO2_ppm);
	
}
mh_z19_create(ser_USART3 com_port,
void(*)(uint16_t CO2_ppm) my_co2_call_back)
{
	CO2_value_ppm = CO2_ppm;
	
	
}

rc void getCo2(uint16_t *CO2_ppm)
{
	#pragma clang diagnostic push
	#pragma clang diagnostic ignored "-Wmissing-noreturn"
	TickType_t xLastWakeTimeCO2=xTaskGetTickCount();
	while(1){
		xSemaphoreTake(*semaphore,CO2_Timer*60);
		printf("CO2 TASK %d \n",xLastWakeTimeCO2);
		
		rc = mh_z19_take_meassuring();
		if (rc != MHZ19_OK )
		{
			printf("CO2_SENSOR_ERROR\n");
		}
		xSemaphoreGive(*semaphore);
		vTaskDelayUntil(&xLastWakeTimeCO2,SENSOR_TIMER*60);
	}
	#pragma clang diagnostic pop
}

