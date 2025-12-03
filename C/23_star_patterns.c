// Print star pyramid and inverted star patterns.
// tags: patterns, loops

// Pattern 1
// * 
// * * 
// * * * 
// * * * * 
// * * * * *

// Pattern 2
//       * 
//      * * 
//     * * * 
//    * * * * 
//   * * * * * 

// Pattern 3
// * * * * * 
// * * * * 
// * * * 
// * * 
// * 


#include <stdio.h>

void main() {
  // pattern 1
  for(int i=0; i < 5; i++) {
    for(int j=0; j <= i; j++) {
      printf("* ");
    }
    printf("\n");
  }


  // pattern 2
  for(int i=0; i < 5; i++) {
    for(int j=i; j <= 5; j++) {
      printf(" ");
    }
    for(int j=0; j <= i; j++) {
      printf("* ");
    }
    printf("\n");
  }


  // pattern 3
  for(int i=0; i < 5; i++) {
    for(int j=i; j < 5; j++) {
      printf("* ");
    }
    printf("\n");
  }
}
