#include "human.h"

#include <stdio.h>

#include "str.h"

struct Human createHuman(char *name, int age, int gender) {
    struct Human human;

    human.age = age;
    human.gender = gender;
    strCopy(name, human.name);

    return human;
}

void printHuman(struct Human *human) {
    printf("Name : %s\n", human->name);
    printf("Age : %d\n", human->age);
    if (human->gender == MALE) {
        printf("Gender : Male\n");
    } else {
        printf("Gender : Female\n");
    }
}