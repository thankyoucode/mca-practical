// Count no. of persons with height >170 and weight <50.
// tags: conditions, loops

#include <stdio.h>

void main() {
  // {{height, weight}, {height, weight},...}
  int persons[5][2] = {{102, 60}, {184, 44}, {183, 53}, {142, 76}, {164, 71}};
  int count = 0;

  for(int i=0; i < 5; i++) {
    printf("%d. height weight: ", i+1);
    scanf("%d %d", &persons[i][0], &persons[i][1]);

    if(persons[i][0] > 170 && persons[i][1] < 50) {
      count++;
    }
  }

  printf("%d Persons have height > 170 and weight < 50\n", count);
}