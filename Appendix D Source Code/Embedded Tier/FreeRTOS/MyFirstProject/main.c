/*
* FreeRTOS_ATMEGA.c
*
* Created: 15/10/2018 13:08:53
* Author : IHA
*/
#include <avr/io.h>
#include <avr/sfr_defs.h>

#include <ATMEGA_FreeRTOS.h>
#include <semphr.h>

#include "../FreeRTOSTraceDriver/FreeRTOSTraceDriver.h"

#include <stdio.h>
#include <stdio_driver.h>

#include "myTimers.h"
#include "co2Sensor.h"
#include "myTasks.h"
#include "mySemaphores.h"
#include "myLora.h"
#include "temp_humSensor.h"


int main(void)
{
	trace_init();
	// stdio_drivers init
	stdioCreate(0);

	// initialization of resources
	// rtos
	semaphores_init();
	timers_init();
	// drivers
	co2_sensor_init();
	temp_hum_sensor_init();
	lora_init();
	
	
	// take semaphores
	// we do not care about result
	// just wanna make sure they are take
	xSemaphoreTake( co2Semaphore, portMAX_DELAY );
	xSemaphoreTake( tempHumSemaphore, portMAX_DELAY );
	xSemaphoreTake( loraSemaphore, portMAX_DELAY );
	
	// tasks
	create_tasks();
	
	vTaskStartScheduler(); // initialize and run the freeRTOS scheduler. Execution should never return here.

	while (1){} // we never should reach here
}

