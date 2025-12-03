// Read, print and add matrices using pointers and functions.
// tags: pointers, matrices

#include <stdio.h>

// in C array by default work like pointer
// but still wont to use pointer syntax for it here is that
// I not use this syntax, I prefer simple array passing

void readMatrice(int (*mat)[2], int m, int n) {
    printf("Enter numbers each time\n");
    for(int i = 0; i < m; i++) {
        for(int j = 0; j < n; j++) {
            printf("> ");
            scanf("%d", &mat[i][j]);
        }
    }
}

void printMatrice(int (*mat)[2], int m, int n) {
    for(int i = 0; i < m; i++) {
        for(int j = 0; j < n; j++) {
            printf("%d\t", mat[i][j]);
        }
        printf("\n");
    }
}

void addMatrices(int (*mat1)[2], int (*mat2)[2], int (*add_mat)[2], int m, int n) {
    for(int i = 0; i < m; i++) {
        for(int j = 0; j < n; j++) {
            add_mat[i][j] = mat1[i][j] + mat2[i][j];
        }
    }
}

int main() {
    const int m = 2, n = 2;
    int matrice1[m][n];
    int matrice2[m][n];
    int add_matrice[m][n];

    readMatrice(matrice1, m, n);
    readMatrice(matrice2, m, n);

    printf("Matrix 1:\n");
    printMatrice(matrice1, m, n);
    printf("Matrix 2:\n");
    printMatrice(matrice2, m, n);

    addMatrices(matrice1, matrice2, add_matrice, m, n);
    printf("Sum:\n");
    printMatrice(add_matrice, m, n);

    return 0;
}
