// Read marks of 4 subjects and check if student passed (all marks >=40) or failed.
// tags: if-else, grading

#include <stdio.h>

void main() {
    int marks[4];
    int i, passed = 1;

    printf("Enter marks of 4 subjects: ");
    for (i = 0; i < 4; i++) {
        scanf("%d", &marks[i]);
        if (marks[i] < 40)
            passed = 0;  // fail if any subject less than 40
    }

    if (passed)
        printf("Pass\n");
    else
        printf("Fail\n");
}
