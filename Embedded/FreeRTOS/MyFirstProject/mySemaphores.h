#ifndef MYSEMAPHORES_H_
#define MYSEMAPHORES_H_

#include "ATMEGA_FreeRTOS.h"

#include <stdio.h>

#include <semphr.h>

SemaphoreHandle_t cycleSemaphore;

SemaphoreHandle_t co2Semaphore;
SemaphoreHandle_t tempHumSemaphore;
SemaphoreHandle_t loraSemaphore;

SemaphoreHandle_t queueSemaphore;

void semaphores_init();

#endif /* MYSEMAPHORES_H_ */