#include <string.h>

#include "human.h"

int main() {
    struct Human lee = createHuman("Lee", 40, MALE);
    printHuman(&lee);

    char str1[20] = "hi";
    char str2[20] = "hello";
    char str3[20] = "hi";

    if (!strcmp(str1, str2)) {
        printf("\"%s\" and \"%s\" is equal\n", str1, str2);
    } else {
        printf("\"%s\" and \"%s\" is NOT equal\n", str1, str2);
    }

    if (!strcmp(str1, str3)) {
        printf("\"%s\" and \"%s\" is equal\n", str1, str3);
    } else {
        printf("\"%s\" and \"%s\" is NOT equal\n", str1, str3);
    }
    return 0;
}