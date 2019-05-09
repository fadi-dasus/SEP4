
/*
 * temp_hum.h
 *
 * Created: 07/05/2019 13.31.52
 *  Author: Roza
 */ 

#ifndef TEMP_HUMSENSOR_H_
#define TEMP_HUMSENSOR_H_

#include "ATMEGA_FreeRTOS.h"

#include <stdbool.h>
#include <stdint.h>
#include <stdio.h>
#include <stdlib.h>
#include <hih8120.h>
#include <serial.h>



void temp_hum_sensor_init();
void temp_hum_measure();
uint16_t temp_get_value();
uint16_t hum_get_value();


#endif /* TEMP_HUMSENSORS_H_ */
