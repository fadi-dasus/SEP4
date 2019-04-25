#ifndef CO2SENSOR_H
#define CO2SENSOR_H
#include <stdbool.h>
#include <stdint.h>
#include <serial/serial.h>

typedef enum
{
	CO2SENSOR_OK
	,CO2SENSOR_NO_MEASSURING_AVAILABLE
	,CO2SENSOR_NO_SERIAL
	,CO2SENSOR_PPM_MUST_BE_GT_999
} CO2SENSOR_return_code_t;

void Co2CallBack(uint16_t ppm);
void co2SensCreate(e_com_port_t com_port,void(*Co2CallBack() )(uint16_t ppm));
CO2SENSOR_return_code_t CO2SENSOR_take_meassuring(void);

CO2SENSOR_return_code_t CO2SENSOR_get_co2_ppm(uint16_t *ppm);

#endif /* CO2SENSOS_H */


