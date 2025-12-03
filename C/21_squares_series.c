// Evaluate series 1^2+2^2+...+n^2.
// tags: series, loops

#include <stdio.h>

void main() {
  int n = 10;

  for(int i = 1; i <= n; i++) {
    printf("%d\t", i*i);
  }
}
