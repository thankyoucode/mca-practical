// Compute series 1+1/2!+1/3!+...+1/n!.
// tags: series, factorial

#include <stdio.h>

void main() {
  int n = 10;
  int fact = 1;
  for(int i = 1; i <= n; i++) {
    fact *= i;
    printf("%d\t", fact);
  }
}
