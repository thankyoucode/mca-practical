// Write a program that performs addition, subtraction, multiplication, and division using switch or if-else.
// tags: operators, switch, if-else

#include <stdio.h>

void main() {
  int a, b;
  char operation;
  double ans;

  printf("Enter you input as  Ex. 10 + 20");
  printf("\nInput: ");
  scanf("%d %c %d", &a, &operation, &b);

  switch(operation) {
    case '+': ans = a + b;  break;
    case '-': ans = a - b;  break;
    case '*': ans = a * b;  break;
    case '/': ans = a / b;  break;
  }

  printf("\nOutput: %.2f", ans);
}
