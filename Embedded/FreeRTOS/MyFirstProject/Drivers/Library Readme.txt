To setup the Hardware Abstraction Layer (HAL) you need do include the following code in your application code before the HAL can be used:

#include <ihal.h>

hal_create(LED_TASK_PRIORITY);  // Set the LED_TASK_PRIORITY to one of the highest priorities
								// in your application


