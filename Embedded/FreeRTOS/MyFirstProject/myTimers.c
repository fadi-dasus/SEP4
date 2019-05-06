/*
 * myTimers.c
 *
 * Created: 06-May-19 11:21:18
 *  Author: robis
 */ 

#include<myTimers.h>

void createTimer(void) {


    timerHandler1Min = xTimerCreate (
        "OneMinuteTimer",       // name
        pdMS_TO_TICKS(55000);   // 55 second delay (+5s from task delay)
        pdTRUE,                 // auto reload
        (void*) 0,              // timer ID
        timerCallBackUnlockMeasuring // callback function for timer
    )
    
    

    if(timerHandler1Min == null)
        while(1); // error
}

void timerCallBackUnlockMeasuring(xTimerHandle pxTimer) {

    if(xSemaphoreGive(xMeasurementSemaphore) != pdTRUE){
        // we should have semaphore to give but in case we dont
        printf("We dont have measurement semaphore");
    }
}