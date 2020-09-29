#include "myTimers.h"
#include "mySemaphores.h"

void timers_init() 
{
	// total 1m:10s cycle
	// timers do not restart automatically 
	
	co2Timer = xTimerCreate(
		"CO2 Timer",
		( 1000/portTICK_PERIOD_MS ) /** 60*/ * 45,	// 7 minute
		pdFALSE,
		( void* ) 0,
		co2_timer_callback
	);
	
	tempHumTimer = xTimerCreate(
		"Temp Hum Timer",
		( 1000/portTICK_PERIOD_MS ) /** 60*/ *5 ,	// 1 minute
		pdFALSE,
		( void* ) 1,
		temp_hum_timer_callback
	);
	
	loraTimer = xTimerCreate(
		"LoRa Timer",
		( 1000/portTICK_PERIOD_MS ) /** 60*/ * 5,	// 1 minute
		pdFALSE,
		( void* ) 2,
		lora_timer_callback
	);
	
	restartCycleTimer = xTimerCreate(
		"Restart Cycle Timer",
		( 1000/portTICK_PERIOD_MS ) /** 60*/ * 15,	// 1 minute
		pdFALSE,
		( void* ) 3,
		restart_cycle_timer_callback
	);
}

void co2_timer_callback(TimerHandle_t pxTimer) 
{
	printf("45s co2 callback");
	if( xSemaphoreTake( cycleSemaphore, portMAX_DELAY ) != pdTRUE )
		printf("ERROR : Cycle semaphore not taken back.");
	if( xSemaphoreGive( co2Semaphore ) != pdTRUE )
		printf("ERROR : CO2 semaphore not given.");
	
	xTimerStart( tempHumTimer, 0 );
}

void temp_hum_timer_callback(TimerHandle_t pxTimer)
{
	printf("5s temp_hum callback");
	if( xSemaphoreTake( co2Semaphore, portMAX_DELAY ) != pdTRUE )
		printf("ERROR : CO2 semaphore not taken back.");
	if( xSemaphoreGive( tempHumSemaphore ) != pdTRUE )
		printf("ERROR : TempHum semaphore not given.");
	
	xTimerStart( loraTimer, 0 );
}

void lora_timer_callback(TimerHandle_t pxTimer) 
{
	printf("5s lora callback");
	if( xSemaphoreTake( tempHumSemaphore, portMAX_DELAY ) != pdTRUE )
		printf("ERROR : TempHum semaphore not taken back.");
	if( xSemaphoreGive( loraSemaphore ) != pdTRUE )		
		printf("ERROR : LoRa semaphore not given.");
		
	xTimerStart( restartCycleTimer, 0 );
}

void restart_cycle_timer_callback(TimerHandle_t pxTimer)
{
	printf("5s restart cycle callback");
	if( xSemaphoreTake( loraSemaphore, portMAX_DELAY ) != pdTRUE )
		printf("ERROR : LoRa semaphore not taken back.");
	if( xSemaphoreGive( cycleSemaphore ) != pdTRUE )
		printf("ERROR : Cycle semaphore not given.");
}