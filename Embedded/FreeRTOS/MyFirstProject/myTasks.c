/*
 * myTasks.c
 *
 * Created: 4/23/2019 4:12:06 PM
 *  Author: robis
 */ 
#include "myTasks.h"
#include "MH_Z19.h"
#include "MyLora.h"

void createTasks(void) {
	xTaskCreate(
		taskMh_z19_take_meassuring
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
		cO2SensMeasure();
		
		
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
		loraSendData();
		
		vTaskDelay(50);
		// PORTA ^= _BV(PA7);
	}
}