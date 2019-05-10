#include "myTimers.h"
#include "mySemaphores.h"

void timers_init() {
	
	CO2Timer = xTimerCreate(
		"CO2 Timer",
		(2000/portTICK_PERIOD_MS),
		pdTRUE,
		(void*) 0,
		co2_timer_callback
	);
	
	TempHumTimer = xTimerCreate(
		"Temp Hum Timer",
		(3000/portTICK_PERIOD_MS),
		pdTRUE,
		(void*) 1,
		temp_hum_timer_callback
	);
	
	LoRaTimer = xTimerCreate(
		"LoRa Timer",
		(3000/portTICK_PERIOD_MS),
		pdTRUE,
		(void*) 2,
		lora_timer_callback
	);
}

void co2_timer_callback(TimerHandle_t pxTimer) {
	//printf("unblock co2 semaphore");
	if( xSemaphoreGive( CO2Semaphore ) != pdTRUE )
	{
		// We would expect this call to fail because we cannot give
		// a semaphore without first "taking" it!
		printf("we dont have ");
		//vTaskDelay(50/portTICK_PERIOD_MS);
	}
	
	//vTaskDelay(4000/portTICK_PERIOD_MS);
	//xSemaphoreTake(CO2Semaphore, portMAX_DELAY);
}

void temp_hum_timer_callback(TimerHandle_t pxTimer){
	//printf("unblock temphum semaphore");
	if( xSemaphoreGive( TempHumSemaphore ) != pdTRUE )
	{
		// We would expect this call to fail because we cannot give
		// a semaphore without first "taking" it!
		printf("we dont have ");
		//vTaskDelay(50/portTICK_PERIOD_MS);
	}
	
	//vTaskDelay(6000/portTICK_PERIOD_MS);
	//xSemaphoreTake(TempHumSemaphore, portMAX_DELAY);
}

void lora_timer_callback(TimerHandle_t pxTimer) {
	printf("unblock lora semaphore ");
	if( xSemaphoreGive( LoRaSemaphore ) != pdTRUE )
	{
		// We would expect this call to fail because we cannot give
		// a semaphore without first "taking" it!
		printf("we dont have ");
		//vTaskDelay(50/portTICK_PERIOD_MS);
	}
}