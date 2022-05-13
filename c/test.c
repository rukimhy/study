#include <stdio.h>

int Soojebi(int base, int exp);

int main() {
    int i, j;

    for (i = 2; i <= 4; i++) {
        for (j = 5; j <= 7; j++) {
            printf("i = %d, j = %d\n", i, j);
        }
    }

    printf("%dx%d=%2d\n", j, i, j * i);

    printf("%d의 16진수 = %x\n", 120, 120);

    printf("Soojebi(2, 10) = %d\n", Soojebi(2, 10));
}

int Soojebi(int base, int exp) {
    int i, result = 1;
    for (i = 0; i < exp; i++) {
        result *= base;
        return result;
    }
}