/*
 * myTimers.h
 *
 * Created: 06-May-19 11:21:00
 *  Author: robis
 */ 


#ifndef MYTIMERS_H_
#define MYTIMERS_H_

#include <ATMEGA_FreeRTOS.h>
#include <stdio.h>

#include <timers.h>

xTimerHandle timerHandler1Min;

void createTimer(void);
void timerCallBackUnlockMeasuring(xTimerHandle pxTimer);

#endif /* MYTIMERS_H_ */