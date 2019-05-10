/*
 * myLora.c
 *
 * Created: 07-May-19 13:29:52
 *  Author: robis
 */ 

#include "myLora.h"
#include "lora_driver.h"
#include <lora_driver.h>
#include <ihal.h>

#define LORA_appEUI "e5459c2af2d9061f"
#define LORA_appKEY "d94d399f47f5e355abbc2f63ad9181e1"

#define LORA_INIT_TASK_PRIORITY 7


//static char _out_buf[100];

void lora_init() {
	
		
		
		hal_create(LORA_INIT_TASK_PRIORITY+1);
		lora_driver_create(ser_USART1);

	/*e_LoRa_return_code_t rc;

		// Join the LoRaWAN
		uint8_t maxJoinTriesLeft = 5;
		do {
			 rc = lora_driver_join(LoRa_OTAA);
			printf("Join Network TriesLeft:%d >%s<\n", maxJoinTriesLeft, lora_driver_map_return_code_to_text(rc));

			if ( rc != LoRa_ACCEPTED)
			{
				// Wait 5 sec and lets try again
				vTaskDelay(pdMS_TO_TICKS(5000UL));
			}
			else
			{
				break;
			}
		} while (--maxJoinTriesLeft);

		if (rc == LoRa_ACCEPTED)
		{
			// Connected to LoRaWAN :-)
		}
		else
		{
			// Something went wrong

			// Lets stay here
			while (1)
			{
				taskYIELD();
			}
		}*/
}


void lora_start(){
	
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
		{
			printf("CONFIGURE_BREAK \n");
		}
		static char dev_eui[17]; // It is static to avoid it to occupy stack space in the task
		if (lora_driver_get_rn2483_hweui(dev_eui) != LoRA_OK)
		{
			printf("HWUI_ERROR \n");
		}	else printf("%s, DEV_EUI \n",dev_eui);

		if (lora_driver_set_otaa_identity(LORA_appEUI,LORA_appKEY,dev_eui) != LoRA_OK)
		{
			printf("IDENTITY_BREAK \n");
		}
		//e_LoRa_return_code_t rc;
		if ((rc=lora_driver_join(LoRa_OTAA)) == LoRa_ACCEPTED)
		{
			printf("LORA_ACCEPTED \n");
			}else if(rc==7){
			for (int i = 0; i < 5; ++i) {
				rc=lora_driver_join(LoRa_OTAA);
				if(rc==7){
					printf("LORA_DENIED\n");
					continue;
					}else{
					printf("LORA_ACCEPTED\n");
					break;
				}
			}
		
}
			}

void lora_send_data() {
	
	vTaskDelay(1000/portTICK_PERIOD_MS);
	printf("lora send");

	// Some dummy payload
	uint16_t hum = 321; // Dummy humidity
	int16_t temp = 642; // Dummy temp
	uint16_t co2_ppm = 1111;//co2_get_value(); // Dummy CO2

	/*uplink_payload.len = 6;
	uplink_payload.port_no = 2;

	uplink_payload.bytes[0] = hum >> 8;
	uplink_payload.bytes[1] = hum & 0xFF;
	uplink_payload.bytes[2] = temp >> 8;
	uplink_payload.bytes[3] = temp & 0xFF;
	uplink_payload.bytes[4] = co2_ppm >> 8;
	uplink_payload.bytes[5] = co2_ppm & 0xFF;*/
	
	lora_payload_t uplink_payload;
	uplink_payload.len = 4; // Length of the actual payload
	uplink_payload.port_no = 4; // The LoRaWAN port no to sent the message to
	uplink_payload.bytes[0] = hum >> 8;
	uplink_payload.bytes[1] = hum & 0xFF;
	uplink_payload.bytes[2] = temp >> 8;
	uplink_payload.bytes[3] = temp & 0xFF;
	
	
	
	


	e_LoRa_return_code_t rc;
	if ((rc = lora_driver_sent_upload_message(false, &uplink_payload)) == LoRa_MAC_TX_OK )
	{
		// The uplink message is sent and there is no downlink message received
		printf("SEND !!");
	}
	else if (rc == LoRa_MAC_RX_OK)
	{
		// The uplink message is sent and a downlink message is received
	}
	else printf("<%i>",rc);
		
	
	vTaskDelay(1000/portTICK_PERIOD_MS);
}