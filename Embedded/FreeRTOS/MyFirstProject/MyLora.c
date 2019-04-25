/*
 * myLoRa.c
 *
 * Created: 4/23/2019 6:11:45 PM
 *  Author: robis
 */ 

#include "MyLora.h"

// to-do
// 1. initialize/create drivers

// 2. send data

#include <stddef.h>
#include <stdio.h>

#include <stdint.h>


#include <ATMEGA_FreeRTOS.h>

#include <lora_driver.h>
#include <iled.h>

// Parameters for OTAA join
#define LORA_appEUI "e5459c2af2d9061f" // Put in your value here
#define LORA_appKEY "d94d399f47f5e355abbc2f63ad9181e1" // Put in your value here

static char _out_buf[100];

static void _lora_test(void);
void lora_handler_task( void *pvParameters );

static lora_payload_t _uplink_payload;


void loraCreates(e_com_port_t com_port)
{
	static e_LoRa_return_code_t rc;
	static uint8_t no_gwys, margin;

	
	lora_driver_create((e_com_port_t) 1);
	lora_driver_configure_to_eu868();
	
}

void loraSendData()
{
	
}
void loraSleep()
{
	
	lora_driver_sleep((uint32_t) 300);
	
}
void loraGetMeassuredData()
{
	
	
} 