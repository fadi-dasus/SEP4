/*
 * file: stdio_driver.h
 *
 * Created: 28/09/2017 15:41:21
 *  Author: IHA
 */ 


#ifndef STDIO_DRIVER_H_ 
#define STDIO_DRIVER_H_

#include <stdbool.h>

/*
	Connects stdin and stdout to the usart_no given. The USART are setup like this:  57600 baud,
	8-bit Data bits, 1 Stop bit and No parity.

	After this is called function is called, it is possible to use printf(), scanf etc.

	@note This function must be called before using printf(), scanf etc.
	@note Remember to enable global interrupt by calling sei().

	@param[in] usart_no no of the USART to setup and connect to stdin and stdout [0..3].
*/
void stdioCreate(uint8_t usart_no);

/*
	Check if there is any inputs ready in the input queue.

	@return true if input is waiting.
*/
bool stdioInputWaiting(void);

#endif /* STDIO_DRIVER_H_ */