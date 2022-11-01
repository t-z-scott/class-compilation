#ifndef VEHICLES_DOT_H
#define VEHICLES_DOT_H

union Vehicle {
    char make[21];
    char vin[18];
    char model[16];
    int year;
} Vehicle;

typedef struct Car {
    union Vehicle;
    int doors;
    int rearConfig; // 0 for hatchback and 1 for trunk
} Car;

typedef struct Truck {
    union Vehicle;
    double towingCap;
    int doors;
} Truck;

typedef struct Boat {
    union Vehicle;
    int motorType; // 0 for inboard and 1 for outboard
} Boat;

void setCar(union Vehicle v, Car c);
void setTruck(union Vehicle v, Truck t);
void setBoat(union Vehicle v, Boat b);

#endif