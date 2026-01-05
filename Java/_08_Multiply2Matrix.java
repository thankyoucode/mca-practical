import java.util.Scanner;

public class _08_Multiply2Matrix {
    public static void print_matrix(int[][] m) {
        System.out.println();
        for(int i = 0; i < 2; i++) {
            for(int j = 0; j < 2; j++) {
                System.out.print(m[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public static void main(String args[]) {
        // first matrix row and second matrix column size same
        // 
        int[][] m1 = {{1, 0}, {2, 4}};
        int[][] m2 = {{6, 8, 23, 1}, {4, 3, 2, 4}};

        int rows1 = m1.length;
        int cols1 = m1[0].length;
        int cols2 = m2[0].length;


        int[][] mm = new int[rows1][cols2];

        for(int i = 0; i < rows1; i++) {
            for(int j = 0; j < cols2; j++) {
                for(int k = 0; k < cols1; k++) {
                    mm[i][j] += m1[i][k] * m2[k][j];
                }    
            }
        }

        for(int i = 0; i < rows1; i++) {
            for(int j = 0; j < cols2; j++) {
                System.out.print(mm[i][j] + "\t");
            }
            System.out.println();
        }
    }
}