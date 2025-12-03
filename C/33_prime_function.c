// Function returns 1 if prime, else 0.
// tags: functions, prime

#include <stdio.h>


int isPrime(int number) {
  // number that only divide by 1 and itself is prime number
  // 1 or less then 1 is not prime number
  if (number <= 1) return 0;

  if (number == 2) return 1; // in even numbers only 2 is prime number

  if (number % 2 == 0) return 0; // in even numbers all other are non-prime numbers

  for(int i=3; i<number; i+=2) { // only check odd number division to check prime number, start from 3 
    if(number % i == 0) return 0;
  }

  return 1;
}

void main() {
  int number = 13;

  int number_is_prime = isPrime(number);

  if(number_is_prime) {
    printf("Yes, %d is prime number", number);
  } else {
    printf("No, %d is not prime number", number);
  }
}
