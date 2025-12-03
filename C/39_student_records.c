// Define struct student_record {name, branch, total_marks} for 10 students.
// tags: structures, records

#include <stdio.h>

struct student_record {
  char name[10];
  char branch[10];
  int total_marks;
};

void main() {
  const int no_std = 10;
  struct student_record stds[no_std];

  printf("input formate 'name branch total_marks'\n");
  for(int i = 0; i < no_std; i++) {
    printf("Student %d: ", i+1);
    scanf("%s %s %d", stds[i].name, stds[i].branch, &stds[i].total_marks);
  }

  printf("Name \t| Branch \t| Total Marks\n");
  printf("------------------------------------\n");
  for(int i = 0; i < no_std; i++) {
    printf("%s \t| %s \t\t| %d\n", stds[i].name, stds[i].branch, stds[i].total_marks);
  }
}
