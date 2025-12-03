// Define struct personal with name, joining date, salary for 5 people.
// tags: structures, records

#include <stdio.h>

struct Employee {
  char name[10];
  char join_date[10];
  int salary;
};

void main() {
  const int no_emp = 5;
  struct Employee emps[no_emp];

  printf("input formate 'name dd-mm-yyyy salary'\n");
  for(int i = 0; i < no_emp; i++) {
    printf("Emp %d: ", i+1);
    scanf("%s %s %d", emps[i].name, emps[i].join_date, &emps[i].salary);
  }

  printf("Name \t| Join Date \t| Salary'\n");
  printf("------------------------------------\n");
  for(int i = 0; i < no_emp; i++) {
    printf("%s \t| %s \t| %d\n", emps[i].name, emps[i].join_date, emps[i].salary);
  }

}
