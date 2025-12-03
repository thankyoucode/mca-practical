// Read three numbers and find maximum using nested if else.
// tags: if-else, comparison

#include <stdio.h>

void main() {
    int a, b, c, max;
    printf("Enter three numbers: ");
    scanf("%d %d %d", &a, &b, &c);

    if (a > b) {
        if (a > c)
            max = a;
        else
            max = c;
    } else {
        if (b > c)
            max = b;
        else
            max = c;
    }
    printf("Maximum number is: %d\n", max);
}
