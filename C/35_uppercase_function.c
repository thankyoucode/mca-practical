// Convert lowercase chars in string to uppercase.
// tags: functions, string

#include <stdio.h>
#include <ctype.h>
// #include <string.h>

void strupr(char *str) {
  for (int i = 0; str[i]; i++) {
    str[i] = toupper((unsigned char)str[i]);
  }
}

// strupr() Function Not Standard, mean always not available in each c compiler
// void strupr(char *str) {
//   strcpy(str, strupr(str));
// }


int main() {
    char str[] = "Hello Mom";
    strupr(str);
    printf("%s\n", str);
    return 0;
}
