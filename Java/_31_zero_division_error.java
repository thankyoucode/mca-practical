// Custom exception class for Divide by Zero error
class DivideByZeroException extends Exception {
  public DivideByZeroException(String message) {
    super(message);
  }
}

public class _31_zero_division_error {
  // Method that throws custom exception
  public static int divide(int a, int b) throws DivideByZeroException {
    if (b == 0) {
      throw new DivideByZeroException("Cannot divide by zero!");
    }
    return a / b;
  }

  public static void main(String[] args) {
    try {
      int result = divide(10, 0);
      System.out.println("Result: " + result);
    } catch (DivideByZeroException e) {
      System.out.println("Zero Division error, Divide by Zero: " + e.getMessage());
    }
  }
}

// Output
// Zero Division error, Divide by Zero: Cannot divide by zero!