#include "str.h"

#include <stdio.h>

void strCopy(char *src, char *dest) {
    while (*src) {
        *dest = *src;
        src++;
        dest++;
    }
    *dest = 0;
}