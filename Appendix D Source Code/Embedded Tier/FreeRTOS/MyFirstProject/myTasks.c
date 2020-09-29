#include "myTasks.h"

void create_tasks(void) {
	
	xTaskCreate(
		start_cycle_task,
		"Start Cycle Task",
		configMINIMAL_STACK_SIZE,
		(void*) 1,
		configMAX_PRIORITIES - 1,
		&startCycleTaskHandler
	);
		
	xTaskCreate(
		co2_measure_task,
		"CO2 Task",
		configMINIMAL_STACK_SIZE,
		(void*) 1,
		configMAX_PRIORITIES - 2,
		&co2MeasureTask
	);	
	
	xTaskCreate(
		temp_hum_measure_task,
		"temp hum Task",
		configMINIMAL_STACK_SIZE,
		(void*) 1,
		configMAX_PRIORITIES - 2,
		&tempHumMeasureTask
	);
	
	xTaskCreate(
		lora_send_data_task,
		"LoRa send data",
		configMINIMAL_STACK_SIZE,
		(void*) 1,
		configMAX_PRIORITIES - 2,
		&loraSendDataTask
	);

}

void start_cycle_task( void *pvParameters )
{
	// remove compiler warnings
	( void )pvParameters;
	
	while(1)
	{
		if( xSemaphoreTake( cycleSemaphore, portMAX_DELAY ) == pdTRUE )
		{		
			// start first timer
			if( xTimerReset( co2Timer, 0 ) != pdTRUE)
				xTimerStart( co2Timer,0 );
			
			xSemaphoreGive( cycleSemaphore );
			// do not run for 9 minutes
			// cycle semaphore should be taken after 7 minutes
			//vTaskDelay( 9 * 60 * ( 1000 / portTICK_PERIOD_MS ));
			vTaskDelay( 55000 / portTICK_PERIOD_MS );
		}
	}
}

void co2_measure_task( void *pvParameters ) 
{
	// remove compiler warnings
	( void )pvParameters;
	
	while(1) 
	{
		if( xSemaphoreTake ( co2Semaphore, portMAX_DELAY ) == pdTRUE ) 
		{
			co2_measure();
			// add measure to queue
			printf("co2 task");
			vTaskDelay( 100 );
			
			xSemaphoreGive( co2Semaphore );
			vTaskDelay( 15000 / portTICK_PERIOD_MS );
		}
	}
}

void temp_hum_measure_task( void *pvParameters ) 
{
	// remove compiler warnings
	( void )pvParameters;
	
	while(1) 
	{
		if( xSemaphoreTake( tempHumSemaphore, portMAX_DELAY ) == pdTRUE ) 
		{
			temp_hum_measure();
			// add values to queue
			
			printf("temp hum task");
			vTaskDelay( 100 );
			
			xSemaphoreGive( tempHumSemaphore );
			vTaskDelay( 15000 / portTICK_PERIOD_MS );
		}
	}
}

void lora_send_data_task( void *pvParameters ) 
{
	// remove compiler warnings
	( void )pvParameters;
	
	lora_start();
	vTaskDelay(100/portTICK_PERIOD_MS);
	
	while(1)
	{
		if( xSemaphoreTake( loraSemaphore, portMAX_DELAY ) == pdTRUE )
		{
			lora_send_data();
			printf("lora task");
			vTaskDelay( 100 );
			
			xSemaphoreGive( loraSemaphore );
			vTaskDelay( 30000 / portTICK_PERIOD_MS );
		}
	}
}



