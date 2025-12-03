// Print number-based patterns (ascending, descending).
// tags: patterns, loops

// Pattern 1
// 1 
// 1 2 
// 1 2 3 
// 1 2 3 4 
// 1 2 3 4 5 

// Pattern 2
// 1 2 3 4 5 
// 1 2 3 4 
// 1 2 3 
// 1 2 
// 1 


// Pattern 3
//  5 5 5 5 5 
//   4 4 4 4 
//    3 3 3 
//     2 2 
//      1 

// Pattern 4
// 1 
// 2 2 
// 3 3 3 
// 4 4 4 4 
// 5 5 5 5 5 


#include <stdio.h>

void main() {
  // pattern 1
  for(int i=1; i <= 5; i++) {
    for(int j=1; j <= i; j++) {
      printf("%d ", j);
    }
    printf("\n");
  }


  // pattern 2
  for(int i=0; i < 5; i++) {
    for(int j=1; j <= 5-i; j++) {
      printf("%d ", j);
    }
    printf("\n");
  }
  
  // pattern 3
  for(int i=5; i >= 0; i--) {
    for(int j=i; j <= 5; j++) {
      printf(" ");
    }
    for(int j=i; j >= 1; j--) {
      printf("%d ", i);
    }
    printf("\n");
  }


  // pattern 3
  for(int i=1; i <= 5; i++) {
    for(int j=1; j <= i; j++) {
      printf("%d ", i);
    }
    printf("\n");
  }

}
