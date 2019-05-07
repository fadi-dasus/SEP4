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

#include "co2Sensor.h"
#include "myTasks.h"


int main(void)
{
	DDRA |= _BV(DDA0) | _BV(DDA7);
	trace_init();
	
	stdioCreate(0);

	co2_sensor_init();
	
	create_tasks();
	
	vTaskStartScheduler(); // initialize and run the freeRTOS scheduler. Execution should never return here.

	/* Replace with your application code */
	while (1)
	{
	}
}

