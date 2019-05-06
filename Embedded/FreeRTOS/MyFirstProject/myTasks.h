/*
 * myTasks.h
 *
 * Created: 4/23/2019 4:12:17 PM
 *  Author: robis
 */ 


#ifndef MYTASKS_H_
#define MYTASKS_H_

#include <ATMEGA_FreeRTOS.h>
#include "../FreeRTOSTraceDriver/FreeRTOSTraceDriver.h"

#include <stdio.h>

#include <avr/io.h>
#include <avr/sfr_defs.h>

#include <task.h>

void createTasks(void);

// tasks
void taskMh_z19_take_meassuring( void *pvParameters );
void taskSendData( void *pvParameters );

#endif /* MYTASKS_H_ */