#include <algorithm>
#include <array>
#include <iostream>
#include <vector>

int search(int* nums, int target) {
    int left = 0;
    int right = (sizeof nums) - 1;

    while (left <= right) {
        int pivot = (left + right) / 2;
        if (nums[pivot] == target)
            return pivot;
        else if (nums[pivot] < target)
            left = pivot + 1;
        else
            right = pivot - 1;
    }
    return -1;
}

int main() {
    int nums[4] = {1, 2, 3, 4};
    std::cout << search(nums, 3)
              << std::endl;
}