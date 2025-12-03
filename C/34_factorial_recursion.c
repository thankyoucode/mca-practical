// Find factorial using recursion.
// tags: recursion, factorial

#include <stdio.h>

long factorial(int n) {
  if(n <= 1) return 1;
  return n * factorial(n-1);
}

void main() {
  int n = 5;
  printf("factorial of %d: %ld", n, factorial(n));
}
