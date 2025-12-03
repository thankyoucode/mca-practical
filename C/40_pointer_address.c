// Print address of a variable using pointer.
// tags: pointers, memory

#include <stdio.h>

void main() {
  int a = 20;
  int *ptr = &a;
  // %p is user for printing address of pointer, generaly for memory address printing
  printf("%p", &a);
}
