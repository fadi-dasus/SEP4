
#include "CO2Sensor.h"
#include "myQueue.h"

uint16_t ppm;
Co2CallBack rc;


//The call back function will be called by the driver when a new CO2 value is returned by the sensor.
void Co2CallBack(uint16_t ppm)
{
	// Here you can use the CO2 ppm value
	ppm=ppm;
	
}
//init/create co2 drivers
// The first parameter is the USART port the MH-Z19 sensor is connected to - in this case USART3
// The second parameter is the address of the call back function
void co2SensCreate(e_com_port_t com_port, void(*)(uint16_t ppm) 	mh_z19_call_back)
{

}

// when u access queue (u are adding value to queue) take semaphore 
// so no other task can manipulate with semaphore
CO2SENSOR_return_code_t CO2SENSOR_take_meassuring(void)
{


	// after meas. is taken save it in ->
	structMeasurement CO2Measurement;
	CO2Measurement.measureCode = MEASUREMENT_C02;
	CO2Measurement.data = 0.0; // replace with data
	
	// push this whole struct to queue
}


CO2SENSOR_return_code_t CO2SENSOR_get_co2_ppm(uint16_t *ppm)
{
	
	
}
