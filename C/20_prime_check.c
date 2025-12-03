// Check whether number is prime or not.
// tags: prime, loops

#include <stdio.h>
#include <stdbool.h>

bool isPrime(int number) {
  // number that only divide by 1 and itself is prime number
  // 1 or less then 1 is not prime number
  if (number <= 1) return false;

  if (number == 2) return true; // in even numbers only 2 is prime number

  if (number % 2 == 0) return false; // in even numbers all other are non-prime numbers

  for(int i=3; i<number; i+=2) { // only check odd number division to check prime number, start from 3 
    if(number % i == 0) return false;
  }

  return true;
}

void main() {
  int number = 13;

  bool number_is_prime = isPrime(number);

  if(number_is_prime) {
    printf("Yes, %d is prime number", number);
  } else {
    printf("No, %d is not prime number", number);
  }
}
