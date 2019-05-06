/*
 * myTasks.c
 *
 * Created: 4/23/2019 4:12:06 PM
 *  Author: robis
 */ 
#include "myTasks.h"
#include "myCO2Sensor.h"
#include "myLoRa.h"

void createTasks(void) {
	xTaskCreate(
		taskMeassureCO2
	,  (const portCHAR *)"TaskMeassureCO2"
	,  configMINIMAL_STACK_SIZE
	,  NULL
	,  2
	,  NULL );

	xTaskCreate(
		taskSendData
	,  (const portCHAR *)"TaskSendData"
	,  configMINIMAL_STACK_SIZE
	,  NULL
	,  2
	,  NULL );
}

/*-----------------------------------------------------------*/
void taskMeassureCO2( void *pvParameters )
{
	#if (configUSE_APPLICATION_TASK_TAG == 1)
	// Set task no to be used for tracing with R2R-Network
	vTaskSetApplicationTaskTag( NULL, ( void * ) 1 );
	#endif

	
	for(;;)
	{
		// test printout
		puts("task1");
		
		// if semaphore is free then
		takeCO2Measurement();
		
		
		vTaskDelay(50);

		// PORTA ^= _BV(PA0);
	}
}

/*-----------------------------------------------------------*/
void taskSendData( void *pvParameters )
{
	#if (configUSE_APPLICATION_TASK_TAG == 1)
	// Set task no to be used for tracing with R2R-Network
	vTaskSetApplicationTaskTag( NULL, ( void * ) 2 );
	#endif
	
	for(;;)
	{
		// test printout
		puts("task2");
		
		// if queue has struct with measureme aka if queue has > 0 elements in
		// then send data
		sendData();
		
		vTaskDelay(50);
		// PORTA ^= _BV(PA7);
	}
}