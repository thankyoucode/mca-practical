// Write a java program to implement Generic class Number_1 for both data type int and float in java.

class Number_1<T extends Number> {
  private T value;

  public Number_1(T value) {
    this.value = value;
  }

  public T getValue() {
    return value;
  }
}

public class _27_GenericClass {
  public static void main(String[] args) {
    Number_1<Number> a = new Number_1<Number>(100); // processing int
    Number_1<Number> b = new Number_1<Number>(2.22f);// processing float
    System.out.println(a.getValue());
    System.out.println(b.getValue());
  }
}
