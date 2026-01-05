import java.util.Scanner;

public class _09_MatrixAddition {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);

        int rows = scan.nextInt(), cols = scan.nextInt();

        int[][] m1 = new int[cols][rows];
        int[][] m2 = new int[cols][rows];
        int[][] mm = new int[cols][rows];

        System.out.println("For Matrix 1 Enter " + (rows * cols));
        for(int i = 0; i < cols; i++) {
            for(int j = 0; j < rows; j++) {
                m1[i][j] = scan.nextInt();
            }
        }

        System.out.println("For Matrix 2 Enter " + (rows * cols));
        for(int i = 0; i < cols; i++) {
            for(int j = 0; j < rows; j++) {
                m2[i][j] = scan.nextInt();
            }
        }


        for(int i = 0; i < cols; i++) {
            for(int j = 0; j < rows; j++) {
                mm[i][j] = m1[i][j] + m2[i][j];
            }
        }

        for(int i = 0; i < cols; i++) {
            for(int j = 0; j < rows; j++) {
                System.out.print(mm[i][j] + "\t");
            }
            System.out.println();
        }
        scan.close();
    }
}