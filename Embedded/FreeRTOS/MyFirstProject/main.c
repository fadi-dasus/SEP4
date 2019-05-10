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
	DDRA |= _BV(DDA0) | _BV(DDA7);
	trace_init();
	stdioCreate(0);

	// initialization of resources
	// semaphores
	semaphores_init();
	// timers
	timers_init();
	// sensors
	co2_sensor_init();
	//temp_hum_sensor_init();
	// lora
	lora_init();
	
	// tasks
	create_tasks();
	
	// timers start
	//xTimerStart(TempHumTimer, 0);
	//xTimerStart(CO2Timer, 0);
	xTimerStart(LoRaTimer, 0);
	
	vTaskStartScheduler(); // initialize and run the freeRTOS scheduler. Execution should never return here.

	/* Replace with your application code */
	while (1)
	{
	}
}

