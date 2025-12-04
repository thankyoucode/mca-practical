// Read text file, count characters per line and total lines.
// tags: files, count

#include <stdio.h>
#include <string.h>

void countCharPerLine(char file_name[]) {
  char str[256];
  FILE *file = fopen(file_name, "r");
  int lines = 0;
  while(fgets(str, sizeof(str), file) != NULL) {
    lines++;
    printf("line %d: char-%ld\n", lines, strlen(str));
  }
  printf("total lines: %d", lines);
  fclose(file);
}

void main() {
  countCharPerLine("48_file_count.c");
}