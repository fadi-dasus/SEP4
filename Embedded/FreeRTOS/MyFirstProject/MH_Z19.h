
/*
 * MH_Z19.h
 *
 * Created: 05/05/2019 23.22.34
 *  Author: Roza
 */ 

#ifndef MH_Z19_H_
#define MH_Z19_H_



#include "ATMEGA_FreeRTOS.h"
#include <stdint-gcc.h>
#include <stdbool.h>
#include <stdint.h>

#include "semphr.h"
#include "queue.h"
#include "Drivers/mh_z19.h"
#include "serial.h"
#include "timers.h"
#include "util/delay.h"
 
mh_z19_return_code_t rc;
int CO2_ppm;
void my_co2_call_back(uint16_t CO2_ppm);
mh_z19_create(ser_USART3 com_port,
void(*)(uint16_t CO2_ppm) my_co2_call_back);
rc Mh_Z19_take_meassuring(void);
rc void getCo2(uint16_t *CO2_ppm);


#endif /*MH_Z19_H_*/


