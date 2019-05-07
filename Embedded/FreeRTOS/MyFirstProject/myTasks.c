#include "myTasks.h"
#include "co2Sensor.h"

void create_tasks(void) {
	
	xTaskCreate(
		co2_measure_task,
		"CO2 Task",
		configMINIMAL_STACK_SIZE,
		(void*) 1,
		2,
		&xCO2MeasureTask
	);
}

void co2_measure_task(void *pvParameters) {
	// remove compiler warnings
	(void)pvParameters;
	
	while(1) {
		
		co2_measure();
		printf("CO2 value = %i \n", co2_get_value());
		
		vTaskDelay(pdMS_TO_TICKS(5000));
	}
}