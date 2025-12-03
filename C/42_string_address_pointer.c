// Print address and value of string characters using pointer.
// tags: pointers, strings

#include <stdio.h>

void main() {
  char string[] = "hello";
  char *ch = string; // directly assigning char array to char pointer it assign first char address to pointer
  while(*ch != '\0') {
    printf("Char: %c,  Address: %p\n", *ch, ch);
    ch++;
  }
}
