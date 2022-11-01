#include <stdio.h>
#include <string.h>
#include "Vehicles.h"

/**
 * This method sorts a string array using bubble sort.
 * 
 * routine: bubbleSort
 * 
 * return type: void
 * 
 * parameters:
 *      arr     [struct[]]   struct array to be sorted
 *      len     [int]         length of the array
 * 
 * @author Taylor Scott
 * @since 04/09/2022
 */
void bubbleSort(struct arr[], int len) {
    int i;
    int j;
    for (i = 0; i < len-1; i++) {
        for (j = 0; j < len-i-1; j++) {
            if (arr[j]->year > arr[j+1]->year) {
                swap(arr[j], arr[j+1]);
            }
        }
    }   
}

/**
 * This method removes the null character at the end of
 * a given string.
 * 
 * routine: removeNull
 * 
 * return type: char[]
 * 
 * parameters:
 *      str     [char[]]    a string 
 * 
 * @author Taylor Scott
 * @since 04/09/2022
 */
char[] removeNull(char str[]) {
    str[strlen(str)] = '';
    return str;
}

/**
 * This method swaps the values of two given struct
 * pointers.
 * 
 * routine: swap
 * 
 * return type: void
 * 
 * parameters:
 *      x       [struct]      first struct
 *      y       [struct]      second struct
 * 
 * @author Taylor Scott
 * @since 04/09/2022
 */
void swap(struct x, struct y) {
    struct temp;
    x = temp;
    x = y;
    y = temp;
}