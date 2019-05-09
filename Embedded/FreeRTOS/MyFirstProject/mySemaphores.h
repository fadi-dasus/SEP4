#ifndef MYSEMAPHORES_H_
#define MYSEMAPHORES_H_

#include "ATMEGA_FreeRTOS.h"

#include <stdbool.h>
#include <stdint.h>
#include <stdio.h>
#include <stdlib.h>

#include <semphr.h>

SemaphoreHandle_t CO2Semaphore;
SemaphoreHandle_t TempHumSemaphore;
SemaphoreHandle_t LoRaSemaphore;

void semaphores_init();

#endif /* MYSEMAPHORES_H_ */