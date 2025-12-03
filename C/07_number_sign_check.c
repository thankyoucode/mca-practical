// Find if a number is positive, negative, or zero.
// tags: if-else, logic

#include <stdio.h>

void main() {
    int num;
    printf("Enter a number: ");
    scanf("%d", &num);

    if(num > 0)
        printf("%d is Positive\n", num);
    else if(num < 0)
        printf("%d is Negative\n", num);
    else
        printf("Number is Zero\n");
}
