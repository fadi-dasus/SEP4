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

#include <serial.h>
#include <mh_z19.h>


void co2_sensor_init();
void co2_callback(uint16_t co2_ppm);
void co2_measure();
uint16_t co2_get_value();



#endif /* CO2SENSOR_H_ */