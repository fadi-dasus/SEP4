#include "mySemaphores.h"

// test semaphore creation
// if new semaphore needed, just follow same procedure
// 1. create handle in .h header file
// 2. initialize semaphore -> xSemaphoreCreate ... (documatation)

void createSemaphores(void){
	
	if ( xTestSemaphore == NULL ) { // Check to confirm that the Semaphore has not already been created.
		xTestSemaphore = xSemaphoreCreateMutex();  // Create a mutex semaphore.
		if ( ( xTestSemaphore ) != NULL ) {
			xSemaphoreGive( ( xTestSemaphore ) );  // Make the mutex available for use, by initially "Giving" the Semaphore.
		}
	}
}