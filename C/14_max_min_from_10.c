// Find maximum and minimum from given 10 numbers.
// tags: loops, arrays

#include <stdio.h>

void main() {
  int arr[10], i, max, min;
  printf("Enter 10 numbers: ");
  for (i = 0; i < 10; i++) {
      scanf("%d", &arr[i]);
  }

  max = arr[0];
  min = arr[0];

  for (i = 1; i < 10; i++) {
      if (arr[i] > max)
          max = arr[i];
      if (arr[i] < min)
          min = arr[i];
  }

  printf("Maximum number is: %d\n", max);
  printf("Minimum number is: %d\n", min);
}
