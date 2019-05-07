#include "myTasks.h"
#include "co2Sensor.h"
#include "myLora.h"

void create_tasks(void) {
	
	xTaskCreate(
		co2_measure_task,
		"CO2 Task",
		configMINIMAL_STACK_SIZE,
		(void*) 1,
		2,
		&xCO2MeasureTask
	);
	
	xTaskCreate(
		lora_send_data_task,
		"LoRa send data",
		configMINIMAL_STACK_SIZE,
		(void*) 1,
		2,
		&xLoRaSendDataTask
	);
}

void co2_measure_task(void *pvParameters) {
	// remove compiler warnings
	(void)pvParameters;
	
	while(1) {
		
		vTaskDelay(1000/portTICK_PERIOD_MS);
		printf("atask co2");
		vTaskDelay(1000/portTICK_PERIOD_MS);
		co2_measure();
		printf("CO2 value = %i \n", co2_get_value());
		
		vTaskDelay(2000/portTICK_PERIOD_MS);
	}
}

void lora_send_data_task(void *pvParameters) {
	
	// remove complier warnings
	(void)pvParameters;
	//static e_LoRa_return_code_t rc;

	// Hardware reset of LoRaWAN transceiver
	lora_driver_reset_rn2483(1);
	vTaskDelay(2);
	lora_driver_reset_rn2483(0);
	// Give it a chance to wakeup
	vTaskDelay(150);

	lora_driver_flush_buffers(); // get rid of first version string from module after reset!

	lora_init();
	
	uplink_payload.len = 6;
	uplink_payload.port_no = 2;

	while(1){
		
		printf("btask lora");
		lora_send_data();
		vTaskDelay(10000/portTICK_PERIOD_MS);
	}
}