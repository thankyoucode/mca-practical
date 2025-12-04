// Merge two files into third file.
// tags: files, merge

#include <stdio.h>

void fileMerge(char *file_a, char *file_b, char *file_m) {
  char str[256];
  FILE *mfile = fopen(file_m, "w");
  
  // write first file to third file
  FILE *file = fopen(file_a, "r");
  while(fgets(str, sizeof(str), file) != NULL) {
    fputs(str, mfile);
  }
  fclose(file);

  // write second file to third file
  file = fopen(file_b, "r");
  while(fgets(str, sizeof(str), file) != NULL) {
    fputs(str, mfile);
  }
  fclose(file);
  fclose(mfile);
}


void main() {
  fileMerge("46_Even.txt", "46_Odd.txt", "49_Numbers.txt");
}
