#include "mySemaphores.h"

void semaphores_init() {
		
	/*do {*/
		if(CO2Semaphore == NULL)
			CO2Semaphore = xSemaphoreCreateMutex();
		if(TempHumSemaphore == NULL)
			TempHumSemaphore = xSemaphoreCreateMutex();
		if(LoRaSemaphore == NULL)
			LoRaSemaphore = xSemaphoreCreateMutex();
		
	/*} while(CO2Semaphore == NULL || TempHumSemaphore == NULL || LoRaSemaphore == NULL);*/

}