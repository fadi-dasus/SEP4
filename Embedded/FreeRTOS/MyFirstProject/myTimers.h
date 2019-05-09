#ifndef MYTIMERS_H_
#define MYTIMERS_H_

#include "ATMEGA_FreeRTOS.h"

#include <stdbool.h>
#include <stdint.h>
#include <stdio.h>
#include <stdlib.h>

#include <timers.h>

TimerHandle_t CO2Timer;
TimerHandle_t TempHumTimer;
TimerHandle_t LoRaTimer;

void timers_init();

void co2_timer_callback(TimerHandle_t pxTimer);
void temp_hum_timer_callback(TimerHandle_t pxTimer);
void lora_timer_callback(TimerHandle_t pxTimer);

#endif /* MYTIMERS_H_ */