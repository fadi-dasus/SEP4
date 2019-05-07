/*
 * myLora.h
 *
 * Created: 07-May-19 13:29:34
 *  Author: robis
 */ 


#ifndef MYLORA_H_
#define MYLORA_H_

#include <stdio.h>
#include <stdint.h>

#include "ATMEGA_FreeRTOS.h"
#include <lora_driver.h>

#define LORA_appEUI "e5459c2af2d9061f"
#define LORA_appKEY "d94d399f47f5e355abbc2f63ad9181e1"

static lora_payload_t uplink_payload;

void lora_init();
void lora_send_data();



#endif /* MYLORA_H_ */