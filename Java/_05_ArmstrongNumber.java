import java.lang.Math;
import java.util.Scanner;

public class _05_ArmstrongNumber {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Number: "); // ex. 153
        int num = scanner.nextInt();
        int num_copy = num;
        int calc_num = 0;
        int len = 0;

        while(num > 0) {
            num /= 10;
            len += 1;
        }

        num = num_copy;

        while(num > 0) {
            calc_num += Math.pow((num % 10), len);
            num /= 10;
        }

        if(num_copy == calc_num) {
            System.out.println("number is Armstrong");
        }
        else {
            System.out.println("number is not Armstrong");
        }
        scanner.close();
    }
}