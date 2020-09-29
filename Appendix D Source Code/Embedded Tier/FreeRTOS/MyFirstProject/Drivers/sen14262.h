/**
\file

\author Ib Havn
\version 1.0.0

\defgroup sen14262_driver Driver for SEN-14262 sound sensor
\{
\brief Driver to the SEN-14262 sound sensor from Sparkfun.

\note this driver is not implemented yet!!!!!!

Description of the SEN-14262 can be found here <a href="https://learn.sparkfun.com/tutorials/sound-detector-hookup-guide?_ga=2.165119417.704281120.1553773860-2113010154.1549288517#introduction">Sound Detector Hookup Guide</a>

The implementation works with interrupt, meaning that there are no busy-waiting involved.

See \ref sen14262_driver_quick_start.

\defgroup sen14262_driver_creation Functions to create and initialize the driver.
\brief How to create the driver.

\defgroup sen14262_driver_basic_function Basic driver functions
\brief Commonly used functions.
Here you you will find the functions you normally will need.

\defgroup sen14262_driver_structs Configuration structs for the SEN-14262 driver functions
\brief Commonly used structs.

\defgroup sen14262_driver_return_codes SEN-14262 driver Return codes
\brief Return codes from SEN-14262 driver functions.
\}
*/

#ifndef SEN14262_H_
#define SEN14262_H_

void sen14262Create(void);

#endif /* SEN14262_H_ */