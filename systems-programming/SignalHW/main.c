#include <stdio.h>
#include <stdlib.h>
#include <signal.h>
// #include <unistd.h>

void handleSigInt(int sig) {
    printf("I'm melting!! mmeeellttiiiingg.......", sig);
    signal(SIGINT, SIG_DFL);
    // exit(sig);
}

int main() {
    signal(SIGINT, handleSigInt);
    int i = 1;
    while (1) {
        printf("%d\n", i);
        i++;
        sleep(1);
    }
    return 0;
}

