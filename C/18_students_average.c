// Calculate average and total of 5 students for 3 subjects.
// tags: nested loops, arrays

#include <stdio.h>

void main() {
  int students = 5;
  int subjects = 3;

  int marks[5][3] = {{70, 76, 68}, {90, 66, 54}, {30, 55, 94}, {87, 73, 65}, {79, 65, 90}};

  for(int i=0; i < students; i++) {
    int total = 0;
    for(int j=0; j < subjects; j++) {
      total += marks[i][j];
    }
    printf("Total: %d\n", total);
    float avg = total/subjects; // a subject absolute marks is 100
    printf("Average: %.2f\n\n", avg);
  }
}
