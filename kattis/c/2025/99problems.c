#include <stdio.h>
#include <stdlib.h>
int main(void) {
    char input[6]; // max 10000 + '\0'
    fgets(input, 6, stdin);

    int n = atoi(input);

    int digits = n % 10;

    if (n < 99) {
        printf("%d", 99);
        return 0;
    }

    int p = (n / 100) * 100; // remove last 2 digits

    int upperRes = p + 99;
    int lowerRes = p - 1;
    // calculate difference
    int res = (upperRes - n > n - lowerRes) ? lowerRes : upperRes;

    printf("%d", res);
    return 0;
}