// Write a java program to implement an interface called Exam with a method Pass (int mark) that
// returns a boolean. Write another interface called Classify with a method Division (int average)
// which returns a String. Write a class called Result which implements both Exam and Classify.
// The Pass method should return true if the mark is greater than or equal to 50 else false. The
// Division method must return “First” when the parameter average is 60 or more, “Second” when
// average is 50 or more but below 60, “No division” when average is less than 50.

interface Exam {
  public boolean pass(int mark);
}


interface Classify {
  public String division(int average);
}

class Result implements Exam, Classify {
  // let asume total absolute mark is 100
  public Result(int mark) {
    boolean isPass = pass(mark);
    if(isPass) {
      System.out.println("You: Pass");
      System.out.println("division: " + division(mark));
    } else {
      System.out.println("Sorry you not able to pass in this exam");
    }
  }

  @Override
  public String division(int average) {
    if (average >= 60) return "First";
    if (average >= 50) return "Second";
    return "No division";
  }

  @Override
  public boolean pass(int mark) {
    if (mark >= 50) return true;
    return false;
  }
  
}

public class _24_Interface {
  public static void main(String[] args) {
    Result myResult = new Result(83);
  }  
}
