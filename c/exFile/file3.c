#include <stdio.h>

int main() {
    FILE* fp = fopen("./txt/c.txt", "r");

    char data[100];

    while (fscanf(fp, "%s", data) != EOF) {
        printf("%s\n", data);
    }
    fclose(fp);
}