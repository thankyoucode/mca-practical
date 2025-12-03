// Find maximum element from 1-D array.
// tags: arrays, search

#include <stdio.h>

void main() {
  int numbers[10] = {30, 23, 63, 75, 98, 55, 29, 90, 45, 88};
  int max = numbers[0];

  for(int i = 1; i < 10; i++) {
    if (max < numbers[i]) {
      max = numbers[i];
    }
  }

  printf("Max: %d", max);
}
