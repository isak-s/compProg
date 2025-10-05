#include <stdio.h>
#include <stdlib.h>

#define MOD 1000000007

long binaryExponentiatepowl(long long a, long long n) {
    if (n == 0) {return 1;}
    long long res = binaryExponentiatepowl(a, n/2);
    if (n % 2) {return (res * res * a)%MOD;}
    else {return (res * res)%MOD;}
}

long countGoodNumbers(long long n) {
    long digitsAtOddIndex = n/2;
    long digitsAtEvenIndex = (n%2) ? digitsAtOddIndex+1 : digitsAtOddIndex;

    long long permutations = binaryExponentiatepowl(4, digitsAtOddIndex)%MOD;
    permutations *= binaryExponentiatepowl(5, digitsAtEvenIndex)%MOD;

    return permutations % MOD;
}

int main() {
    char input[15];

    fgets(input, 15, stdin);

    int n = atoll(input);

    printf("%ld", countGoodNumbers(n));
}


/* we can count the amount of permutations instead of computing
5 even : "0" "2" 4 6 8

digits at odd indices have to be prime
     there exists 4 diferent prime digits : 2 3 5 7

*/
// use binary exponentiation to perform 5 * 5 * 5 and 4 * 4 * 4 faster
    // calculate the impact of all 4s and 5s seperately
    // then multiply together in the last step