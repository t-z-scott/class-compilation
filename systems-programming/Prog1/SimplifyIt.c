#include <stdio.h>

long a = 10000, b, c =2800, d, e, f[2801], g;
int main() {
    printf("Terse Version: ");
    for (;b-c;) f[++b]=a/5;
        for(;d=0,g=c*2;c-=14,printf("%.4d",e+d/a),e=d%a)
            for(b=c;d+=f[b]*a,f[b]=d%--g,d/=g--,--b;d*=b);

    printf("\nVerbose Version: ");
    int r[2801];
    int t, s, i, k;
    int c = 0;
    for (i = 0; i < 2800; i++) {
        r[i] = 2000;
    }

    for (k = 2800; k > 0; k = k - 14) {
        for (s = 0, i = k; i != 0; s = s / t, i = i - 1) {
            s = s + r[i] * a;
            t = 2 * i - 1;

            r[i] = s % t;
            if (i != 0) {
                s = s * i;
            }
        }
        printf("%.4d", c + s / a);
        c = s % a;
    }
    return 0;
}