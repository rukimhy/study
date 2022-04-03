#include <stdio.h>
void readChar(void *p, int byte);
int main() {
    int i = 0x12345678;
    printf("0x%x\n", i);
    readChar(&i, 4);

    return 0;
}

void readChar(void *p, int byte) {
    do {
        printf("%x\n", *(char *)p);
        byte--;
        p = (char *)p + 1;
    } while (p && byte);
}