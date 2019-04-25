#ifndef MYQUEUE_H
#define MYQUEUE_H

#define MEASUREMENT_C02 0
#define MEASUREMENT_hum 1
#define MEASUREMENT_temp 2

#include <ATMEGA_FreeRTOS.h>
#include "../FreeRTOSTraceDriver/FreeRTOSTraceDriver.h"

#include <stdio.h>
#include <queue.h>

typedef struct Measurements {
    int measureCode;
    float data;
} structMeasurement;

QueueHandle_t xQueueMeasurements;

void createQueues(void);

#endif /* MYQUEUE_H */

