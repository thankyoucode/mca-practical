// Find factorial of given number using iteration.
// tags: loops, math

#include <stdio.h>

void main() {
  int n, i, fact = 1;
  printf("Enter a number: ");
  scanf("%d", &n);

  for (i = 1; i <= n; i++) {
      fact *= i;
  }

  printf("Factorial of %d is %d\n", n, fact);
}
