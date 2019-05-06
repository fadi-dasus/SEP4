#include "Drivers/mh_z19.h"

void mh_z19_call_back(uint16_t ppm)
{
	// Here you can use the CO2 ppm value
	
}

void mh_z19_create(e_com_port_t com_port,	void(*)(uint16_t ppm) 	mh_z19_call_back )
{
	
	

}

rc mh_z19_take_meassuring(void)
{
	
	rc = mh_z19_take_meassuring();
	if (rc != MHZ19_OK)
	{
		// Something went wrong
		printf ("something went wrong\n");
	}
	else
	{
		
		
	}
	
	
}

rc mh_z19_get_co2_ppm(uint16_t *ppm)
{
	
	
}

