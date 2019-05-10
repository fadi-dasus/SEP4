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

#include "co2Sensor.h"
#include "myLora.h"
#include "mySemaphores.h"
#include "myTimers.h"
#include "temp_humSensor.h"

#include <task.h>
#include <timers.h>

TaskHandle_t startCycleTaskHandler;

TaskHandle_t co2MeasureTask;
TaskHandle_t tempHumMeasureTask;
TaskHandle_t loraSendDataTask;

void create_tasks( void );

void start_cycle_task( void *pvParameters );
void co2_measure_task( void *pvParameters );
void temp_hum_measure_task( void *pvParameters );
void lora_send_data_task( void *pvParameters );

#endif /* MYTASKS_H_ */