// Read marks and display grade (Distinction, First, Second, Fail).
// tags: if-else ladder, grading

#include <stdio.h>

void main() {
  int marks;
  printf("Enter marks: ");
  scanf("%d", &marks);

  if (marks >= 80)
      printf("Distinction\n");
  else if (marks >= 60)
      printf("First Class\n");
  else if (marks >= 40)
      printf("Second Class\n");
  else
      printf("Fail\n");
}
