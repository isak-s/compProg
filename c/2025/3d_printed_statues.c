#include <stdio.h>
#include <string.h>
#include <stdlib.h>
int main(void) {
    //printf("%d", 5/4);
    int n; // statues
    int p = 1; // printers
    int d = 0; // days

    FILE* fp = fopen("0input.txt", "r");
    char input[6]; // max 10000 including '\0'
    fgets(input, 6, fp);

    n = atoi(input);

    //printf("day %d pc: %d\n", d, p);
    while (n - p > 0) { // n/p >= 1) {
        p *= 2; // all printers make new printers
        d += 1; // a day passes
        //printf("day %d pc: %d\n", d, p);
    }
    d += 1; // one day to actually print it

    printf("%d", d);
    return 0;
}