class Mouse {
  public final String brand = "ZEBRONICS";

  // final class can not be override

  final public void clickLeft() {
    System.out.println("Click Left");
  }
  final public void clickRight() {
    System.out.println("Click Right");
  }
  final public void scroll() {
    System.out.println(":) sorry you have not that on your mouse. (In my case)");
  }
}

public class _21_Final {
  public static void main(String[] args) {
    Mouse myMouse = new Mouse();
    // The final field Mouse.brand cannot be assigned
    // myMouse.brand = "Not Known";
    myMouse.clickLeft();
    myMouse.scroll();
  }
}
