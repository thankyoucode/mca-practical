// Access array elements with pointers.
// tags: pointers, arrays

#include <stdio.h>

void main() {
  float random_nums[] = {10.2433, 5923.9283, 298384, 2888.394, 68923.28384};
  float *num_ptr = random_nums;
  int len = sizeof random_nums / sizeof random_nums[0]; // getting length of array
  for(int i = 0; i < len; i++, num_ptr++) {
    printf("%f\n", *num_ptr);
  }
}
