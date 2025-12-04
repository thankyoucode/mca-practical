// Convert string into uppercase.
// tags: string, conversion

#include <stdio.h>
#include <ctype.h>
// #include <string.h>

int main() {
    char str[] = "Hello Mom";
    for (int i = 0; str[i]; i++) {
      str[i] = toupper((unsigned char)str[i]);
    }

    // strupr() Function Not Standard, mean always not available in each c compiler
    // strcpy(str, strupr(str));

    printf("%s\n", str);
    return 0;
}
