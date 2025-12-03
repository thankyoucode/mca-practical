// Print alphabet-based pyramid patterns.
// tags: patterns, loops

// pattern 1
// A A A A A 
// B B B B 
// C C C 
// D D 
// E 

// pattern 2
// A B C D E 
// A B C D 
// A B C 
// A B 
// A 

#include <stdio.h>

void main() {
  char abcd[5] = "ABCDE";

  // pattern 1
  for(int i=0; i < 5; i++) {
    for(int j=1; j <= 5-i; j++) {
      printf("%c ", abcd[i]);
    }
    printf("\n");
  }
  
  // pattern 2
  for(int i=0; i < 5; i++) {
    for(int j=0; j < 5-i; j++) {
      printf("%c ", abcd[j]);
    }
    printf("\n");
  }
}
