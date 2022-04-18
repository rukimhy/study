#include <stdio.h>

int func1(int N);
int func2(int *arr, int N);
int func3(int N);
int func4(int N);

int main() {
    int arr1[3] = {1, 52, 48};
    int arr2[2] = {50, 42};
    int arr3[4] = {4, 13, 63, 87};
    printf("%d, %d, %d\n", func1(16), func1(34567), func1(27639));
    // printf("%d, %d, %d\n", func2(arr1, 3), func2(arr2, 2), func2(arr3, 4));
    printf("%d, %d, %d\n", func3(9), func3(693953651), func3(756580036));
    printf("%d, %d, %d\n", func4(5), func4(97615282), func4(1024));
}

int func1(int N) {
    int sum = 0;
    for (int i = 1; i <= N; i++) {
        if (i % 3 == 0 || i % 5 == 0) {
            sum += i;
        }
    }
    return sum;
}

int func2(int *arr, int N) {
    for (int i = 0; i < N; i++) {
        for (int j = i + 1; i < N; j++) {
            if (arr[i] + arr[j] == 100) {
                return 1;
            }
        }
    }
    return 0;
}

int func3(int N) {
    for (int i = 0; i < N; i++) {
        if (i * i == N) {
            return 1;
        }
    }
    return 0;
}

int func4(int N) {
    // for (int i = N; i > 0; i--) {
    //     int tmp = i;
    //     while (1) {
    //         if (tmp % 2 == 1)
    //             break;
    //         else {
    //             tmp = tmp / 2;
    //             if (tmp == 1) return i;
    //         }
    //     }
    // }
    // return 0;

    int val = 1;
    while (val * 2 <= N) val *= 2;
    return val;
}