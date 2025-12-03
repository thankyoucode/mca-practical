// Swap two values using pointers.
// tags: pointers, swap

#include <stdio.h>

void swap(int *a, int *b) {
  int temp = *a;
  *a = *b;
  *b = temp;
}

void main() {
  int a = 10, b = 20;
  printf("%d - %d\n", a, b);
  swap(&a, &b);
  printf("%d - %d < After swap", a, b);
}
