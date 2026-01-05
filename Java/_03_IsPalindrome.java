import java.util.Scanner;

public class _03_IsPalindrome {
    public static void main(String args[]) {
        Scanner scanner  = new Scanner(System.in);
        int number, number_copy, number_reverce;
        number = scanner.nextInt();
        number_copy = number;
        number_reverce = 0;

        while(number > 0) {
            number_reverce = number_reverce * 10 + (number % 10);
            number /= 10;
        }

        if(number_copy == number_reverce) {
            System.out.println("This number: " + number_copy + " is Palindrome");
        }
        else {
            System.out.println("This number: " + number_copy + " Not is Palindrome");
        }
        scanner.close();
    }
}