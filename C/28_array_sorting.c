// Sort array in ascending order (bubble/selection sort).
// tags: arrays, sorting

#include <stdio.h>

// bottom to top
void bubbleSort(int nums[], int len) {
  for(int i = 0; i < len; i++) {
    for(int j = len-1; j > i; j--) {
      if (nums[j] < nums[j-1]) {
        // swaping numbers | can use temp variable to swap
        nums[j] = nums[j] ^ nums[j-1];
        nums[j-1] = nums[j] ^ nums[j-1];
        nums[j] = nums[j] ^ nums[j-1];
      }
    }
  }
}


// top to bottom
void bubbleSort2(int nums[], int len) {
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

void selectionSort(int nums[], int len) {
  int min_index;
  for(int i = 0; i < len; i++) {
    min_index = i;
    for(int j = i+1; j < len; j++) {
      if (nums[min_index] > nums[j]) {
        min_index = j;
      }
    }
    if(nums[min_index] != nums[i]) {
      nums[i] = nums[i] ^ nums[min_index];
      nums[min_index] = nums[i] ^ nums[min_index];
      nums[i] = nums[i] ^ nums[min_index];
    }
  }
}

void main() {
  int len = 10;
  // int numbers[10] = {30, 23, 63, 75, 98, 55, 29, 90, 45, 88};
  int numbers[10] = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};

  // bubbleSort(numbers, len);
  // bubbleSort2(numbers, len);
  selectionSort(numbers, len);

  for(int i=0; i < len; i++) {
    printf("%d  ", numbers[i]);
  }
}
