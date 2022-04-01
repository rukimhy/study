#include <stdio.h>

int str_length(char *str);
int str_equal(char *a, char *b);

int main() {
    char null_1 = '\0';
    char null_2 = 0;
    // char null_3 = (char)NULL;

    char not_null = '0';

    printf("NULL의 정수(아스키)값 : %d, %d\n", null_1, null_2);
    printf("'0'의 정수(아스키)값 : %d\n", not_null);

    char sentence_1[4] = {'P', 's', 'i', '\0'};
    char sentence_2[4] = {'P', 's', 'i', 0};
    // char sentence_3[4] = {'P', 's', 'i', (char)NULL};
    char sentence_4[4] = {"Psi"};

    printf("sentence_1 : %s\n", sentence_1);
    printf("sentence_2 : %s\n", sentence_2);
    // printf("sentence_3 : %s\n", sentence_3);
    printf("sentence_4 : %s\n", sentence_4);

    char str[] = {"What is your name?"};
    printf("이 문자열의 길이 : %d\n", str_length(str));

    char words[30];
    printf("문자열 입력 : ");
    scanf("%s", words);
    printf("문자열 : %s\n", words);

    char str_a[] = "abc";
    char str_b[] = "abc";
    if (str_equal(str_a, str_b)) {
        printf("equals");
    } else {
        printf("different");
    }

    return 0;
}

int str_length(char *str) {
    int i = 0;
    while (str[i]) {
        i++;
    }

    return i;
}

int str_equal(char *a, char *b) {
    int i = 0;
    while (a[i]) {
        if (a[i] == b[i]) {
            i++;
        } else {
            return 0;
        }
    }
    return 1;
}