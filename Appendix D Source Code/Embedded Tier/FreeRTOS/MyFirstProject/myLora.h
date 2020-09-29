/*
 * myLora.h
 *
 * Created: 07-May-19 13:29:34
 *  Author: robis
 */ 


#ifndef MYLORA_H_
#define MYLORA_H_
// includes
#include "ATMEGA_FreeRTOS.h"

#include <stdio.h>
#include <stdint.h>

#include <lora_driver.h>
#include <ihal.h>

// defines
#define LORA_appEUI "e5459c2af2d9061f"
#define LORA_appKEY "d94d399f47f5e355abbc2f63ad9181e1"

// function prototypes
void lora_init();
void lora_start();
void lora_send_data();

#endif /* MYLORA_H_ */