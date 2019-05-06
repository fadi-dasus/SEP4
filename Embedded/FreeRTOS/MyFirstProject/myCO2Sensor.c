#include "myCO2Sensor.h"
#include "myQueue.h"

// init/create co2 drivers
void createCO2Drivers(void){

}

// when u access queue (u are adding value to queue) take semaphore 
// so no other task can manipulate with semaphore
void takeCO2Measurement(void){

	// after meas. is taken save it in ->
	structMeasurement CO2Measurement;
	CO2Measurement.measureCode = MEASUREMENT_C02;
	CO2Measurement.data = 0.0; // replace with data
	
	// push this whole struct to queue
}