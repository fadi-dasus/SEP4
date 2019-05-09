
#include "myTasks.h"
#include "co2Sensor.h"
#include "myLora.h"
#include "mySemaphores.h"
#include "myTimers.h"
#include <timers.h>

//int rand_val = 1234;

void create_tasks(void) {
	
	/*xTaskCreate(
		co2_measure_task,
		"CO2 Task",
		configMINIMAL_STACK_SIZE,
		(void*) 1,
		2,
		&CO2MeasureTask
	);*/	
	
	/*xTaskCreate(
		temp_hum_measure_task,
		"temp hum Task",
		configMINIMAL_STACK_SIZE,
		(void*) 1,
		2,
		&TempHumMeasureTask
	);*/
	
	xTaskCreate(
		lora_send_data_task,
		"LoRa send data",
		configMINIMAL_STACK_SIZE,
		(void*) 1,
		2,
		&LoRaSendDataTask
	);
}

void co2_measure_task(void *pvParameters) {
	// remove compiler warnings
	(void)pvParameters;
	
	
	
	while(1) {
	
		
		
		//printf("CO2 task");
		//vTaskDelay(50/portTICK_PERIOD_MS);
		if(xSemaphoreTake(CO2Semaphore, portMAX_DELAY) == pdTRUE) {
			vTaskDelay(8000/portTICK_PERIOD_MS);
		
			co2_measure();
			uint16_t co2 = co2_get_value();
			printf("CO2 value = %d \n", co2);
			xSemaphoreGive(CO2Semaphore);
		}
	}
}

void lora_send_data_task(void *pvParameters) {
	
	
	while(1){
			printf("task lora");
			vTaskDelay(1000/portTICK_PERIOD_MS);
			
		if(xSemaphoreTake(LoRaSemaphore, portMAX_DELAY) == pdTRUE){
			vTaskDelay(4000/portTICK_PERIOD_MS);
			lora_start();
			lora_send_data();
		}
	}
}


void temp_hum_measure_task(void *pvParameters) {
	// remove compiler warnings
	(void)pvParameters;
	
	
	while(1) {
		
		//printf("temp task");
		//vTaskDelay(50/portTICK_PERIOD_MS);
		if(xSemaphoreTake(TempHumSemaphore, portMAX_DELAY) == pdTRUE) {
			vTaskDelay(4000/portTICK_PERIOD_MS);
			//temp_measure();
			//printf("temp value = %i \n", /*co2_get_value()*/ rand_val);
			xSemaphoreGive(TempHumSemaphore);
		}
	}
}