// Reverse digits of number using %10 method.
// tags: loops, arithmetic

#include <stdio.h>

void main() {
  int a = 70720, reverse_a=0;

  while(a > 0) {
    reverse_a = 10*reverse_a + a%10;
    a /= 10;
  }

  printf("Reverse digits %d\n", reverse_a);
}
