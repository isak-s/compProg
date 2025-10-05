#include <stdio.h>
#include <string.h>

int main(void) {
    long long a, b;
    // scanf("%lld %lld", &a, &b) reads 2 longs from stdin and stores them in a and b
    while (scanf("%lld %lld", &a, &b) == 2) {
        long long diff = a - b;
        diff = (diff >= 0) ? diff : -diff;
        printf("%lld\n", diff);
    }
    return 0;
}