// Define struct time_struct {hour, minute, second} and display formatted time.
// tags: structures, time

#include <stdio.h>

struct TimeStruct {
  int hour;
  int minute;
  int second;
};

typedef struct TimeStruct time_struct;

void printTime(time_struct time) {
  printf("%.2d:%.2d:%.2d\n", time.hour, time.minute, time.second);
}

void main() {
  time_struct time;
  time.hour = 11;
  time.minute = 43;
  time.second = 2;
  printTime(time);
}
