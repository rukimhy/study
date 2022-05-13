#include <stdio.h>
#include <string.h>

int main() {
    FILE *fp = fopen("./txt/b.txt", "r+");
    if (fp == NULL) {
        fp = fopen("./txt/b.txt", "w+");
        fputs("There is some data.", fp);
        fseek(fp, 0, SEEK_SET);

        char data[100];
        fgets(data, 100, fp);
        printf("현재 파일에 있는 내용 : %s\n", data);

        fclose(fp);
        return 0;
    }

    char data[100];
    fgets(data, 100, fp);
    printf("현재 파일에 있는 내용 : %s\n", data);
    fseek(fp, 0, SEEK_SET);

    char comp[6];
    strncpy(comp, data, 5);
    if (!strcmp(comp, "ADDUU")) {
        fputs("There", fp);
        fseek(fp, 0, SEEK_SET);
    } else {
        fputs("ADDUU", fp);
        fseek(fp, 0, SEEK_SET);
    }

    fgets(data, 100, fp);
    printf("바뀐 파일에 있는 내용 : %s\n", data);
    fseek(fp, 0, SEEK_SET);

    fclose(fp);

    return 0;
}