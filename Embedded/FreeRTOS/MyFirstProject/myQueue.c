#include "myQueue.h"

// so far we need just one queue as far as I know
// should be created
// check that stucture in header file if it is ok 
// myQueues .c and .h should be done -> u can use xQueueMeasurements (global)

void createQueues(){

    // create a queue containing 3 measurement structs. */
    xQueueMeasurements = xQueueCreate( 3, sizeof( structMeasurement ) );

    if( xQueueMeasurements == NULL ) {
        // queue was not created and must not be used.
        // should we call this again ? #recursion ? 
    }

}