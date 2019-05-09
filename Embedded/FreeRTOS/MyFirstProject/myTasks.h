/*
 * co2Sensor.h
 *
 * Created: 07-May-19 10:28:42
 *  Author: robis
 */ 


#ifndef MYTASKS_H_
#define MYTASKS_H_

#include "ATMEGA_FreeRTOS.h"

#include <stdbool.h>
#include <stdint.h>
#include <stdio.h>
#include <stdlib.h>

#include <task.h>

TaskHandle_t CO2MeasureTask;
TaskHandle_t TempHumMeasureTask;
TaskHandle_t LoRaSendDataTask;

void create_tasks(void);

void co2_measure_task(void *pvParameters);
void temp_hum_measure_task(void *pvParameters);
void lora_send_data_task( void *pvParameters);


#endif /* MYTASKS_H_ */