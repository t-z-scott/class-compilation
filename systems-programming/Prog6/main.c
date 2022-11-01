#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "BubbleSort.h"
#include "Vehicles.h"

/**
 * This program reads a list of strings from a text file,
 * stores them in vehicle structs based on type, sorts
 * those structs by ascending year throuhg bubble sort,
 * then prints the attributes of each vehicle to another
 * text file.
 * 
 * CSC 3304 Programming project No 6
 * 
 * @author Taylor Scott
 * @since 04/24/2022
 */
enum vehicleType { car = 1, boat, truck };
int main() {

    int length = 20;             // length of struct* array
    struct Truck pointers[length];    // struct* array
    // dynamically allocate memory for pointers[]
    pointers = (Truck*)malloc (length * sizeof(Truck));
    int i = 0;                  // iterator for pointers[] in while loop
    vehicleType v;              // enum for type
    union Vehicle vec;          // vehicle union
    const int MAX_CHARS = 51;   // max chars in a string
    char type[MAX_CHARS];       // vehicle type string
    char line[MAX_CHARS];       // current text line string
    FILE* in = fopen("TestInput.txt", "r");
    FILE* out = fopen("out.txt", "w");

    while (!feof(in)) {

        // determine type using enum
        fgets( removeNull(type), MAX_CHARS, in );
        if (strcmp(type, "car") == 0) {
            v = 1;
        }
        else if (strcmp(type, "boat") == 0) {
            v = 2;
        }
        else if (strcmp(type, "truck") == 0) {
            v = 3;
        }
        // assign values to struct 'vec'
        fgets( removeNull(vec->make), MAX_CHARS, out );
        fgets( removeNull(vec->model), MAX_CHARS, out );
        fgets( removeNull(vec->year), MAX_CHARS, out );
        fgets( removeNull(vec->vin), MAX_CHARS, out );
        // assign other values to vec by type
        switch (v) {
            case 1:
                Car c;
                setCar(vec, c);
                vec->rearConfig = 0;
                fgets( removeNull(vec->doors), MAX_CHARS, out );
                fgets( removeNull(line), MAX_CHARS, in );
                if (strcmp(line, "trunk") == 0) vec->rearConfig = 1;
                if (strlen(pointers) == length) length++;
                pointers[i] = *c;
                i++;
                break;
            case 2:
                Boat b;
                setBoat(vec, b);
                vec->motorType = 0;
                fgets( removeNull(line), MAX_CHARS, in );
                if (strcmp(line, "outboard") == 0) vec->motorType = 1;
                if (strlen(pointers) == length) length++;
                pointers[i] = *b;
                i++;
                break;
            case 3:
                Truck t;
                setTruck(vec, t);
                fgets(vec->doors, MAX_CHARS, out);
                fgets( removeNull(vec->towingCap), MAX_CHARS, out );
                if (strlen(pointers) == length) length++;
                pointers[i] = *t;
                i++;
                break;
            default:
                printf("Error! vehicleType v is %d.", v);
                return 1;
                break;
        }

        fprintf(out, "%d %s %s\nVIN: %s\n", vec->year, vec->make,
            vec->model, vec->vin);
        if (v == 1) {
            fprintf(out, "Doors: %d\n", vec->doors);
            fprintf(out, "Max Towing Capacity: %lf\n", );
        }
        else if (v == 2) {
            if (vec->motorType == 1) fprintf(out, "Motor: outboard\n");
            else fprintf(out, "Motor: inboard\n");
        }
        else if (v == 3) {
            fprintf(out, "Doors: %d\n", vec->doors);
            if (vec->rearConfig == 1) {
                fprintf(out, "Rear Configuration: trunk\n");
            }
            else fprintf(out, "Rear Configuration: hatchback\n");
        }

    }
    fclose(in);
    fclose(out);

    // sort structs by acending year using bubble sort
    bubbleSort(pointers, length);
    // dynamically deallocate memory using free()
    free(pointers);

    return 0;
}