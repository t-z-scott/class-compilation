all: program6
program6: main.o BubbleSort.o Vehicles.o
    gcc -o program6 main.o BubbleSort.o Vehicles.o
main.o: main.c BubbleSort.h Vehicles.h
    gcc -c main.c
Vehicles.o: Vehicles.c Vehicles.h
	gcc -c Vehicles.c
BubbleSort.o: BubbleSort.c BubbleSort.h Vehicles.h
    gcc -c BubbleSort.c Vehicles.c
clean:
    rm BubbleSort.o program6
	rm Vehicles.o program6
    rm main.o program6