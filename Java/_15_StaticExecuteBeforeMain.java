public class _15_StaticExecuteBeforeMain {
  // 1. first execute this
  public static int nums = 100;

  // static block is execute one time when first time class is executed
  // this execute before main or any other methods in class
  // the position is not matter it canbe after main or last but execute always first
  static {
    System.out.println("Static Hello");
    System.out.println(nums);
  }

  public static void main(String[] args) {
    System.out.println("hello from main");
  }
}
