#include <stdio.h>
#include <stdlib.h>

void printArray(int a, int b, int (*array)[a]);
int main() {
    int x, y;
    int **arr;

    printf("arr[x][y]를 만들 것입니다. x, y : ");
    scanf("%d %d", &x, &y);

    arr = (int **)malloc(sizeof(int *) * x);

    for (int i = 0; i < x; i++) {
        arr[i] = (int *)malloc(sizeof(int) * y);
    }

    printf("생성 완료! \n");
    for (int i = 0; i < x; i++) {
        free(arr[i]);
    }
    free(arr);

    int a, b;
    printf("array[a][b]를 만들 것입니다. a, b : ");
    scanf("%d %d", &a, &b);
    int(*array)[a] = (int(*)[a])malloc(sizeof(int) * a * b);

    int data = 0;
    for (int i = 0; i < a; i++) {
        for (int j = 0; j < b; j++) {
            array[i][j] = data++;
        }
    }
    printArray(a, b, array);
    free(array);

    return 0;
}

void printArray(int a, int b, int (*array)[a]) {
    for (int i = 0; i < a; i++) {
        for (int j = 0; j < b; j++) {
            printf("array[%d][%d] = %d\n", i, j, array[i][j]);
        }
    }
}