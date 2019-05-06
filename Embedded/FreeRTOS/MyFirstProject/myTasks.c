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
	// CO2 meassure
	xTaskCreate(
		taskMh_z19_take_meassuring
	,  (const portCHAR *)"TaskMeassureCO2"
	,  configMINIMAL_STACK_SIZE
	,  NULL
	,  2
	,  NULL );

	// lora send data
	xTaskCreate(
		taskSendData
	,  (const portCHAR *)"TaskSendData"
	,  configMINIMAL_STACK_SIZE
	,  NULL
	,  2
	,  NULL );

	// check queue
	xTaskCreate(
		taskCheckQueue
	,  (const portCHAR *)"TaskCheckQueue"
	,  configMINIMAL_STACK_SIZE
	,  NULL
	,  2
	,  NULL );
	
	// run timer
	xTaskCreate(
		taskRunTimer
	,  (const portCHAR *)"TaskRunTimer"
	,  configMINIMAL_STACK_SIZE
	,  NULL
	,  configMAX_PRIORITIES - 1
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

void taskRunTimer(void * pvParameters) {

	#if (configUSE_APPLICATION_TASK_TAG == 1)
	// Set task no to be used for tracing with R2R-Network
	vTaskSetApplicationTaskTag( NULL, ( void * ) 2 );
	#endif
	
	while(1) {

		if(xSemaphoreTake(xMeasurementSemaphore, 100) == pdTRUE) {

			xTimerStart(timerHandler1Min, 0);

			vTaskDelay(5000/portTICK_PERIOD_MS); // 5 second delay
		}
	}
}

void taskCheckQueue(void *pvParameters) {
 
	#if (configUSE_APPLICATION_TASK_TAG == 1)
	// Set task no to be used for tracing with R2R-Network
	vTaskSetApplicationTaskTag( NULL, ( void * ) 2 );
	#endif

	while(1) {
		
		if(uxQueueSpacesAvailable <= 0) {

			// all measurement task should be suspended
			// resume send data task
		}
	}
}