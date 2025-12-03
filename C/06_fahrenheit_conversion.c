// Compute Fahrenheit from Centigrade using f = 1.8*c + 32.
// tags: conversion, formula

#include <stdio.h>

// float fahrenheit(float c) {
//   return 1.8*c + 32;
// }

void main() {
  float c;
  printf("Enter Centigrade: ");
  scanf("%f", &c);

  printf("%.2fc = %.2fF", c, 1.8*c + 32);
}
