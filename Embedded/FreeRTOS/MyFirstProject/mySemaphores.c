#include "mySemaphores.h"

void semaphores_init() {
	
		cycleSemaphore = xSemaphoreCreateMutex();
		if( cycleSemaphore == NULL )
			cycleSemaphore = xSemaphoreCreateMutex();	// try one more time
	
		co2Semaphore = xSemaphoreCreateMutex();
		if( co2Semaphore == NULL )
			co2Semaphore = xSemaphoreCreateMutex();		// try one more time
				
		tempHumSemaphore = xSemaphoreCreateMutex();	
		if( tempHumSemaphore == NULL )
			tempHumSemaphore = xSemaphoreCreateMutex();	// try one more time
		
		loraSemaphore = xSemaphoreCreateMutex();	
		if( loraSemaphore == NULL )
			loraSemaphore = xSemaphoreCreateMutex();	// try one more time
		
		queueSemaphore = xSemaphoreCreateMutex();
		if( queueSemaphore == NULL )
			queueSemaphore = xSemaphoreCreateMutex();	// try one more time
}