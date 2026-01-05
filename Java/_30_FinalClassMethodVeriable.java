// final class - can't be extended
final class FinalClass {
  // final variable - can't change value once set
  final int MAX_SCORE = 100;

  // final method - can't be overridden
  final void showFinalMsg() {
    System.out.println("This method can't be changed by subclass!");
  }
}

// This won't compile:
// class SubClass extends FinalClass { } // ERROR!

public class _30_FinalClassMethodVeriable {
  public static void main(String[] args) {
    FinalClass fc = new FinalClass();
    fc.showFinalMsg();
  }
}
