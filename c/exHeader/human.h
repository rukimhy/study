#include <stdio.h>

enum {
    MALE,
    FEMALE
};

struct Human {
    char name[20];
    int age;
    int gender;
};

struct Human createHuman(char *name, int age, int gender);
void printHuman(struct Human *human);