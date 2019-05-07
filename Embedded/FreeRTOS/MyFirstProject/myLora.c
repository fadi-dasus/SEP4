/*
 * myLora.c
 *
 * Created: 07-May-19 13:29:52
 *  Author: robis
 */ 

#include "myLora.h"


static char _out_buf[100];

void lora_init() {
	
	printf("lora init");
	e_LoRa_return_code_t rc;

	// Factory reset the transceiver
	printf("FactoryReset >%s<\n", lora_driver_map_return_code_to_text(lora_driver_rn2483_factory_reset()));
	
	// Configure to EU868 LoRaWAN standards
	printf("Configure to EU868 >%s<\n", lora_driver_map_return_code_to_text(lora_driver_configure_to_eu868()));

	// Get the transceivers HW EUI
	rc = lora_driver_get_rn2483_hweui(_out_buf);
	printf("Get HWEUI >%s<: %s\n",lora_driver_map_return_code_to_text(rc), _out_buf);

	// Set the HWEUI as DevEUI in the LoRaWAN software stack in the transceiver
	printf("Set DevEUI: %s >%s<\n", _out_buf, lora_driver_map_return_code_to_text(lora_driver_set_device_identifier(_out_buf)));

	// Set Over The Air Activation parameters to be ready to join the LoRaWAN
	printf("Set OTAA Identity appEUI:%s appKEY:%s devEUI:%s >%s<\n", LORA_appEUI, LORA_appKEY, _out_buf, lora_driver_map_return_code_to_text(lora_driver_set_otaa_identity(LORA_appEUI,LORA_appKEY,_out_buf)));

	// Save all the MAC settings in the transceiver
	printf("Save mac >%s<\n",lora_driver_map_return_code_to_text(lora_driver_save_mac()));

	// Enable Adaptive Data Rate
	printf("Set Adaptive Data Rate: ON >%s<\n", lora_driver_map_return_code_to_text(lora_driver_set_adaptive_data_rate(LoRa_ON)));

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
	}
}

void lora_send_data() {
	
	printf("lora send");
	vTaskDelay(pdMS_TO_TICKS(5000UL));

	// Some dummy payload
	uint16_t hum = 12345; // Dummy humidity
	int16_t temp = 675; // Dummy temp
	uint16_t co2_ppm = co2_get_value(); // Dummy CO2

	uplink_payload.bytes[0] = hum >> 8;
	uplink_payload.bytes[1] = hum & 0xFF;
	uplink_payload.bytes[2] = temp >> 8;
	uplink_payload.bytes[3] = temp & 0xFF;
	uplink_payload.bytes[4] = co2_ppm >> 8;
	uplink_payload.bytes[5] = co2_ppm & 0xFF;

	printf("Upload Message >%s<\n", lora_driver_map_return_code_to_text(lora_driver_sent_upload_message(false, &uplink_payload)));
}