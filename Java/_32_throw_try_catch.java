class Plain {
  public float weight, cary_weight = 1000;

  Plain(float in_weight) {
    weight = in_weight;
  }

  public void takeOf() throws Throwable {
    if (weight > cary_weight) {
      throw new Throwable("Weight is overloded");
    } else {
      System.out.println("All is ok, we going to take of this plain");
    }
  }
}

public class _32_throw_try_catch {
  public static void main(String[] args) throws Throwable {
    // try-catch-finally example
    try {
      int a = 10 / 0; // creting error
      System.out.println("connecting to database");
    } catch (Exception e) {
      System.out.println("Database error");
    } finally {
      System.out.println("Disconneting to database");
    }

    // custome plain error
    Plain plain = new Plain(1100);
    plain.takeOf(); // if here error come from stop execution
    System.out.println("Plain take of"); // on plain.takeOf(); this not execute
  }
}