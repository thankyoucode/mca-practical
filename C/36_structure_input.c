// Read structure elements from keyboard.
// tags: structures, input

#include <stdio.h>

struct Developer {
  char name[10];
  char field[25];
};

void main() {
  struct Developer k;
  printf("Enter Dev name: ");
  scanf("%s", k.name);
  printf("Enter Dev field: ");
  scanf("%s", k.field);

  printf("Hi, %s you are working in %s", k.name, k.field);
}
