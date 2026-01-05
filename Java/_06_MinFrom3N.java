import java.util.Scanner;

public class _06_MinFrom3N {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter 3 numbers:");
        int a=scan.nextInt(), b=scan.nextInt(), c=scan.nextInt(), min;

        if (a < b) {
            if (a < c) {
                min = a;
            } else {
                min = c;
            }
        } else {
            if (b < c) {
                min = b;
            } else {
                min = c;
            }
        }

        System.out.println("Min is: " + min);
        scan.close();
    }
}