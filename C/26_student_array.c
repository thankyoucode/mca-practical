// Read and store roll no and marks of 20 students.
// tags: arrays, input

#include <stdio.h>

void main() {
  int no_students = 20;

  int marks[20][2]; // {{roll_no, marks}, {roll_no, marks}, ...}

  printf("You are going to enter %d students marks\n", no_students);
  for(int i = 0; i < no_students; i++) {
    printf("%d. Enter roll_no and marks as 'roll_no marks': ", i+1);
    scanf("%d %d", &marks[i][0], &marks[i][1]);
  }

  printf("\nSr no.\t| Roll no.\t| Marks\n");
  printf("-----------------------------------\n");
  for(int i = 0; i < no_students; i++) {
    printf("%d\t| %d\t\t| %d\n", i+1, marks[i][0], marks[i][1]);
  }
}
