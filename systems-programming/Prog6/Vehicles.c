#include <stdio.h>
#include "Vehicles.h"

void setCar(Vehicle v, Car c) {
    c->make = v->make;
    c->model = v->model;
    c->year = v->year;
    c->vin = v->vin;
}

void setTruck(Vehicle v, Truck t) {
    t->make = v->make;
    t->model = v->model;
    t->year = v->year;
    t->vin = v->vin;
}

void setBoat(Vehicle v, Boat b) {
    b->make = v->make;
    b->model = v->model;
    b->year = v->year;
    b->vin = v->vin;
}