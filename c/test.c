#include <stdio.h>
int main() {
    int i, j;

    for (i = 2; i <= 4; i++) {
        for (j = 5; j <= 7; j++) {
            printf("i = %d, j = %d\n", i, j);
        }
    }

    printf("%dx%d=%2d\n", j, i, j * i);

    printf("%d의 16진수 = %x\n", 120, 120);
}