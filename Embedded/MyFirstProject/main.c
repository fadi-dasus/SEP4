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

#include "mySemaphores.h"
#include "myQueue.h"
#include "myTasks.h"
#include "CO2Sensor.h"


int main(void)
{
	DDRA |= _BV(DDA0) | _BV(DDA7);
	trace_init();


	createSemaphores();
	createTasks();
	createQueues();
	co2SensCreate();
	
	vTaskStartScheduler(); // initialize and run the freeRTOS scheduler. Execution should never return here.

	/* Replace with your application code */
	while (1)
	{
	}
}

