#include <stdio.h>
#include <stdlib.h>
#include <string.h>


int main(void) {
    char *str = NULL;
    size_t len = 0;
    while (getline(&str, &len, stdin) != -1) {
        int i = 0;
        int prevL = 0;
        // solvable in 0 steps
        while (str[i] != '\0') {
            if (prevL) {
                if (str[i] == 'v') {
                    printf("%d\n", 0);
                    free(str);
                    return 0;
                }
            }
            prevL = (str[i] == 'l') ? 1 : 0;
            i++;
        }
        // if it contains one of them, one action is required.
        // if it contains none, two actions are required.
        if (strchr(str, 'v') || strchr(str, 'l')){
            printf("%d\n", 1);
            free(str);
            return 0;
        }

    }

    printf("%d\n", 2);
    free(str);
    return 0;
}