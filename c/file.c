#include <stdio.h>

FILE *updateFile(char *name, char *str);
int main() {
    FILE *fp = fopen("a.txt", "w");
    if (fp == NULL) {
        printf("Write Error!\n");
        return 0;
    }
    fputs("Hello, world!\n", fp);
    fclose(fp);

    FILE *fp2 = fopen("a.txt", "r");
    char buf[20];
    fgets(buf, 20, fp2);
    printf("입력받은 내용 : %s", buf);

    fseek(fp2, 0, SEEK_SET);
    printf("다시 입력받음 : ");
    char c;
    while ((c = fgetc(fp2)) != EOF) {
        printf("%c", c);
    }
    fclose(fp2);

    FILE *fp3 = updateFile("a.txt", "super");
    fclose(fp3);

    return 0;
}

FILE *updateFile(char *name, char *str) {
    FILE *fp_read = fopen(name, "r");
    char buf[100];
    fgets(buf, 100, fp_read);

    FILE *fp = fopen(name, "w");
    if (fp == NULL) {
        printf("Write Error!\n");
        return 0;
    }
    fputs(buf, fp);
    fseek(fp, 0, SEEK_SET);
    fputs(str, fp);

    return fp;
}