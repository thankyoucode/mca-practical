// Generate first n Fibonacci numbers.
// tags: loops, series

#include <stdio.h>

void main() {
  int n, a=0, b=2, temp;
  printf("Inter first n: ");
  scanf("%d", &n);

  for(int i = 0; i < n; i++) {
    printf("%d\t", a);
    temp = b;
    b = a + b;
    a = temp;
  }
}
