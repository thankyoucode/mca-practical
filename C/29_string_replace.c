// Replace a character in given string.
// tags: string, replace

#include <stdio.h>

void replaceChar(char string[], char ch, int index) {
  string[index] = ch;
}

void main() {
  char string[] = "Hello";
  replaceChar(string, 'L', 0);
  printf("%s", string);
}
