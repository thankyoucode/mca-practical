// Accept lines from user, store in file, then print contents.
// tags: files, input-output

#include <stdio.h>
#include <string.h>

void main() {
  // opening file in write mode , if not exist it create if exist is rewrite efrom start as new
  FILE *file = fopen("47_just_text.txt", "w");
  char string[256];
  printf("Write text to file enter `EOF` to end this writing: \n");
  while (fgets(string, sizeof(string), stdin) != NULL) {
    string[strcspn(string, "\n")] = 0;
    if (strstr(string, "EOF")) {
      string[strcspn(string, "EOF")] = 0;
      fprintf(file, "%s\n", string);
      break;
    }
    fprintf(file, "%s\n", string); // Write with newline preserved
  }
  fclose(file);
  // openging as read view file need to exist here
  file = fopen("47_just_text.txt", "r");
  printf("File contents:\n");
  // reading context of this file
  while (fgets(string, sizeof(string), file) != NULL) {
      printf("%s", string);
  }
  fclose(file);
}
