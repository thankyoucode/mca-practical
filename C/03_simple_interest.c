// Write a program to calculate simple interest i = (p*r*n)/100.
// tags: math, finance

#include <stdio.h>

void main() {
  float p, r, n, i;

  printf("Enter Amount Rate Year: ");
  scanf("%f %f %f", &p, &r, &n);

  i = (p*r*n)/100;

  printf("Interest is: %.2f", i);
}
