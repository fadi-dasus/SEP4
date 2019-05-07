/*
 * co2Sensor.h
 *
 * Created: 07-May-19 10:28:42
 *  Author: robis
 */ 


#ifndef CO2SENSOR_H_
#define CO2SENSOR_H_

#include "ATMEGA_FreeRTOS.h"

#include <stdbool.h>
#include <stdint.h>
#include <stdio.h>
#include <stdlib.h>

#include <task.h>

TaskHandle_t xCO2MeasureTask;
TaskHandle_t xLoRaSendDataTask;

void create_tasks(void);

void co2_measure_task(void *pvParameters);
void lora_send_data_task( void *pvParameters);


#endif /* CO2SENSOR_H_ */