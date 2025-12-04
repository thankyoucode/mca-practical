// Store n numbers in file, separate even/odd into Even.txt & Odd.txt.
// tags: files, arrays

#include <stdio.h>

void display(char file_name[]) {
  char str[256];
  FILE *file = fopen(file_name, "r");
  printf("File: %s >>>\n", file_name);
  while(fscanf(file, "%s", str) != EOF) {
    printf("%s\n", str);
  }
  fclose(file);
}

void main() {
  int n = 10;
  int a;

  // Read nums
  FILE *nums_file = fopen("46_numbers.txt", "w");
  printf("Enter %d numbers\n", n);
  for(int i = 0; i < n; i++) {
    // input n number from keyboard
    scanf("%d", &a);
    fprintf(nums_file, "%d\n", a);

    // uncomment next line if wont to skip manual input, and comment above two < helpful if you are not reguler coder ha..ha..
    // fprintf(nums_file, "%d\n", i+1);
  }
  fclose(nums_file);


  // reading all number from main file and putting acording to even or odd file
  nums_file = fopen("46_numbers.txt", "r");
  FILE *even_file = fopen("46_Even.txt", "w");
  FILE *odd_file = fopen("46_Odd.txt", "w");
  while(fscanf(nums_file, "%d", &a) != EOF) {
    if(a % 2 == 0) {
      fprintf(even_file, "%d\n", a);
    } else {
      fprintf(odd_file, "%d\n", a);
    }
  }
  
  fclose(nums_file);
  fclose(even_file);
  fclose(odd_file);

  display("46_numbers.txt");
  display("46_Even.txt");
  display("46_Odd.txt");
}
