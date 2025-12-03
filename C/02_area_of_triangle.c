// Write a program to calculate area of triangle using formula (0.5 * base * height).
// tags: formula, math

#include <stdio.h>

void main() {
  float a, h, b;

  printf("Enter you input as : height base");
  printf("\nInput: ");
  scanf("%f %f", &h, &b);

  a = h * b * 0.5;

  printf("\nOutput: %.2f", a);
}
