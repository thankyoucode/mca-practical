import java.util.Scanner;

public class _07_MaxFrom4N {

    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        int num, max=0;

        System.out.println("\nEnter 4 numbers:");
        for(int i = 0; i < 4; i++) {
            num = scan.nextInt();
            if(num > max) max = num;
        }

        System.out.println("Max is: " + max);
        scan.close();
    }

}