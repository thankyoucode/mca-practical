// Sort array using pointers.
// tags: pointers, sorting

#include <stdio.h>

// here is `int *nums` it work same in normal syntax `int nums`
void bubbleSort(int *nums, int len) {
  for(int i = 0; i < len; i++) {
    for(int j = 0; j < len - i - 1; j++) {
      if (nums[j] > nums[j+1]) {
        nums[j] = nums[j] ^ nums[j+1];
        nums[j+1] = nums[j] ^ nums[j+1];
        nums[j] = nums[j] ^ nums[j+1];
      }
    }
  }
}

void main() {
  int len = 10;
  int numbers[10] = {30, 23, 63, 75, 98, 55, 29, 90, 45, 88};

  bubbleSort(numbers, len);

  for(int i=0; i < len; i++) {
    printf("%d  ", numbers[i]);
  }
}
