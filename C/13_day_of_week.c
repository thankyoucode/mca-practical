// Read number 1-7 and print corresponding day using switch-case.
// tags: switch, logic

#include <stdio.h>

void main() {
  int day;
  printf("Enter number 1-7: ");
  scanf("%d", &day);

  switch(day) {
      case 1: printf("Sunday"); break;
      case 2: printf("Monday"); break;
      case 3: printf("Tuesday"); break;
      case 4: printf("Wednesday"); break;
      case 5: printf("Thursday"); break;
      case 6: printf("Friday"); break;
      case 7: printf("Saturday"); break;
      default: printf("Invalid input! Please enter a number between 1 and 7.");
  }
}
