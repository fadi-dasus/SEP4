#ifndef MYSEMAPHORES_H
#define MYSEMAPHORES_H

#include <ATMEGA_FreeRTOS.h>
#include <stdio.h>

#include <semphr.h>

// define semaphore handle
SemaphoreHandle_t xTestSemaphore;

void createSemaphores(void);

#endif /* MYSEMAPHORES_H */

