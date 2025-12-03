// Reverse a string.
// tags: string, reverse

#include <stdio.h>

void reverseStr(char string[], int len) {
  if(len <= 1) return;
  char ch;
  for(int j = 0, k = len-1; j < k; j++, k--) {
    ch = string[j];
    string[j] = string[k];
    string[k] = ch;
  }
}

void main() {
  char string[] = "Hello";
  reverseStr(string, 5);
  printf("%s", string);
}

