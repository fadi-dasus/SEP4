/*
 * myLora.c
 *
 * Created: 07-May-19 13:29:52
 *  Author: robis
 */ 

#include "myLora.h"
#include "temp_humSensor.h"
#include "co2Sensor.h"

#define LORA_appEUI "e5459c2af2d9061f"
#define LORA_appKEY "d94d399f47f5e355abbc2f63ad9181e1"

#define LORA_INIT_TASK_PRIORITY 7


//static char _out_buf[100];

void lora_init() 
{		
		hal_create(LORA_INIT_TASK_PRIORITY+1);
		lora_driver_create(ser_USART1);
}


void lora_start()
{
	e_LoRa_return_code_t rc;
	
	lora_driver_reset_rn2483(1);
	vTaskDelay(2);
	lora_driver_reset_rn2483(0);
	vTaskDelay(150);
	
	if (lora_driver_rn2483_factory_reset() != LoRA_OK)
	{
		printf("FACTORY_RESET_FAILURE \n");
	}
		
	vTaskDelay(150);

	if (lora_driver_configure_to_eu868() != LoRA_OK)
		printf("CONFIGURE_BREAK \n");
		
	// It is static to avoid it to occupy stack space in the task
	static char dev_eui[17];
	if (lora_driver_get_rn2483_hweui(dev_eui) != LoRA_OK)
	{
		printf("HWUI_ERROR \n");
	}	
	else 
		printf("%s, DEV_EUI \n",dev_eui);

	if (lora_driver_set_otaa_identity(LORA_appEUI,LORA_appKEY,dev_eui) != LoRA_OK)
	{
		printf("IDENTITY_BREAK \n");
	}
	
	if ((rc=lora_driver_join(LoRa_OTAA)) == LoRa_ACCEPTED)
	{
		printf("LORA_ACCEPTED \n");
	}
	else if(rc==7) 
	{
		for (int i = 0; i < 5; ++i)
		{
			rc=lora_driver_join(LoRa_OTAA);
			if(rc==7)
			{
				printf("LORA_DENIED\n");
				continue;
			}
			else
			{
				printf("LORA_ACCEPTED\n");
				break;
			}
		}
	}
	// total delay 0seconds 302ticks
}

void lora_send_data()
{
	// just in case it didnt join last time
	// should skip after first if
	e_LoRa_return_code_t rc;
	/*if ((rc=lora_driver_join(LoRa_OTAA)) == LoRa_ACCEPTED)
	{
		printf("LORA_ACCEPTED \n");
	}
	else if(rc==7)
	{
		for (int i = 0; i < 5; ++i)
		{
			rc=lora_driver_join(LoRa_OTAA);
			if(rc==7)
			{
				printf("LORA_DENIED\n");
				continue;
			}
			else
			{
				printf("LORA_ACCEPTED\n");
				break;
			}
		}
	}*/
	
	vTaskDelay(100/portTICK_PERIOD_MS);
	
	lora_driver_flush_buffers(); // get rid of first version string from module after reset!

	vTaskDelay(100/portTICK_PERIOD_MS);
	// Some dummy payload
	uint16_t hum = hum_get_value(); // Dummy humidity
	int16_t temp = temp_get_value(); // Dummy temp
	uint16_t co2_ppm = co2_get_value(); // Dummy CO2

	lora_payload_t uplink_payload;
	
	uplink_payload.len = 6;
	uplink_payload.port_no = 1; 
	
	uplink_payload.bytes[0] = hum >> 8;
	uplink_payload.bytes[1] = hum & 0xFF;
	uplink_payload.bytes[2] = temp >> 8;
	uplink_payload.bytes[3] = temp & 0xFF;
	uplink_payload.bytes[4] = co2_ppm >> 8;
	uplink_payload.bytes[5] = co2_ppm & 0xFF;
	
	if ((rc = lora_driver_sent_upload_message(false, &uplink_payload)) == LoRa_MAC_TX_OK )
	{
		// The uplink message is sent and there is no downlink message received
	}
	else if (rc == LoRa_MAC_RX_OK)
	{
		// The uplink message is sent and a downlink message is received
	}
	else if (rc == LoRA_OK)
	{
		// everything went ok, message sent
		printf("Return code (Send upload message) -> %i ",rc); 
	}
	else 
		printf(">%s<", lora_driver_map_return_code_to_text(rc));
	// total delay 0seconds 500ticks
}