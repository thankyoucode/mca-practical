// Write a program to interchange two numbers using temp variable, arithmetic, or pointers.
// tags: variables, swap

#include <stdio.h>

void printAB(int a, int b) {
  printf("\nA: %d, B: %d", a, b);
}

void main() {
  int a = 11, b= 22;
  printAB(a, b);

  // using temp variable
  int temp = a;
  a = b;
  b = temp;
  printAB(a, b);

  // using arithmetic
  a = a + b;
  b = a - b;
  a = a - b;
  printAB(a, b);

  // using pointer
  int *x = &a, *y = &b;
  *x = *x ^ *y;
  *y = *x ^ *y;
  *x = *x ^ *y;
  printAB(a, b);
}