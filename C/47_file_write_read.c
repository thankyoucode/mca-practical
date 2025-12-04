// Accept lines from user, store in file, then print contents.
// tags: files, input-output

#include <stdio.h>
#include <string.h>

void display(char file_name[]) {
  char str[256];
  FILE *file = fopen(file_name, "r");

  printf("File: %s >>>\n", file_name);
  while(fgets(str, sizeof(str), file) != NULL) {
    printf("%s", str);
  }
  fclose(file);
}

void main() {
  FILE *file = fopen("47_just_text.txt", "w");
  char str[256];

  printf("Write text to file (end with `EOF`)\n");
  while (fgets(str, sizeof(str), stdin) != NULL) {
    if (strstr(str, "EOF")) {
      str[strcspn(str, "EOF")] = 0;
      fprintf(file, "%s\n", str);
      break;
    }
    fprintf(file, "%s", str);
  }
  fclose(file);

  // displya file context
  display("47_just_text.txt");
}
