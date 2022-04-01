#include <stdio.h>

struct Human {
    int age;
    int height;
    int weight;
} being = {20, 30, 40};

struct Test {
    int a, b;
    char str[30];
} TestShort;

struct Academy {
    struct Test test;
    int a;
};

int add_one(int *a);
void str_cpy(char *dest, char *src);
void setTest(struct Test *t, int a, int b, char *str);
struct Test returnTest(int i);

int main() {
    struct Human psi;

    psi.age = 99;
    psi.height = 185;
    psi.weight = 80;

    printf("psi에 대한 정보\n");
    printf("나이   : %d\n", psi.age);
    printf("키     : %d\n", psi.height);
    printf("몸무게 : %d\n", psi.weight);

    struct Test st;
    struct Test *ptr = &st;

    (*ptr).a = 1;
    ptr->b = 2;

    printf("st의 a멤버 : %d\n", st.a);
    printf("st의 b멤버 : %d\n", st.b);

    struct Test tt;
    struct Test *t = &tt;
    t->a = 0;
    add_one(&t->a);
    printf("t->a = %d\n", t->a);

    struct Test str_test;
    str_cpy(str_test.str, "hello, world!");
    printf("str_test.str : %s\n", str_test.str);

    *t = str_test;
    printf("t->str : %s\n", t->str);

    struct Test functionTest;
    setTest(&functionTest, 1, 2, "function");
    printf("%d, %d, %s\n", functionTest.a, functionTest.b, functionTest.str);

    struct Test function2link;
    struct Test *functionTest2 = &function2link;
    setTest(functionTest2, 5, 6, "function2");
    printf("%d, %d, %s\n", functionTest2->a, functionTest2->b, functionTest2->str);

    struct Academy academy;
    setTest(&academy.test, 3, 4, "academy");
    academy.a = 5;
    printf("%d, %d, %s, %d\n", academy.test.a, academy.test.b, academy.test.str, academy.a);

    academy.test.a = returnTest(2).a;
    printf("%d, %d\n", academy.test.a, academy.test.b);

    academy.test = returnTest(1);
    printf("%d, %d\n", academy.test.a, academy.test.b);

    TestShort.a = 10;
    str_cpy(TestShort.str, "shit!");
    printf("%s == %d\n", TestShort.str, TestShort.a);

    struct Test shorter = {1, 2, "gogo"};
    printf("%d, %d, %s\n", shorter.a, shorter.b, shorter.str);
    printf("%d, %d, %d\n", being.age, being.height, being.weight);

    return 0;
}

int add_one(int *a) {
    *a += 1;
    return 0;
}

void str_cpy(char *dest, char *src) {
    while (*src) {
        *dest = *src;
        dest++;
        src++;
    }
    *dest = 0;
}

void setTest(struct Test *t, int a, int b, char *str) {
    t->a = a;
    t->b = b;
    str_cpy(t->str, str);
}

struct Test returnTest(int i) {
    struct Test t;
    t.a = i;

    return t;
}