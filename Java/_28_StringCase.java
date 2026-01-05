import java.util.Scanner;

public class _28_StringCase {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();
        
        String result = reverseCase(input);
        System.out.println("Original: " + input);
        System.out.println("Reversed case: " + result);
        
        scanner.close();
    }
    
    public static String reverseCase(String str) {
        StringBuilder reversed = new StringBuilder();
        
        for (char c : str.toCharArray()) {
            if (Character.isUpperCase(c)) {
                reversed.append(Character.toLowerCase(c));
            } else if (Character.isLowerCase(c)) {
                reversed.append(Character.toUpperCase(c));
            } else {
                reversed.append(c); // Keep non-letters unchanged
            }
        }
        
        return reversed.toString();
    }
}

// OUTPUT:
// Enter a string: ABCdef
// Original: ABCdef
// Reversed case: abcDEF