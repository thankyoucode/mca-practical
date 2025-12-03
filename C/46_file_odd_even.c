// Store n numbers in file, separate even/odd into Even.txt & Odd.txt.
// tags: files, arrays

#include <stdio.h>

void main() {
  FILE *nums_file = fopen("46_numbers.txt", "r");
  FILE *even_file = fopen("46_Even.txt", "w");
  FILE *odd_file = fopen("46_Odd.txt", "w");
  int n;
  while(fscanf(nums_file, "%d", &n) != EOF) {
    if(n % 2 == 0) {
      fprintf(even_file, "%d\n", n);
    } else {
      fprintf(odd_file, "%d\n", n);
    }
  }
  fclose(nums_file);
  fclose(even_file);
  fclose(odd_file);
}
