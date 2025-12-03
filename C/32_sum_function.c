// Define function to add first n numbers.
// tags: functions, math

#include <stdio.h>

int sum(int n) {
  int total = 0;
  for(int i = 1; i <= n; i++) {
    total += i;
  }
  return total;
}

void main() {
  int n = 100;
  printf("Sum 1 to %d: %d", n, sum(n));
}
