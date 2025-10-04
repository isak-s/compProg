#include <stdio.h>

int main(void) {
    int input;
    scanf("%d", &input);

    int label = (input < 13) ? input : input + 1;

    printf("%d\n", label);
    return 0;
}