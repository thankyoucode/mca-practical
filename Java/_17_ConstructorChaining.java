// Write a class “Circle” with radius as data member and count the number of instancescreated using default constructor only. [Constructor Chaining]

class Circle {
  public double radius;
  private static int count = 0;
  public Circle() {
    count++;
  }
  public Circle(double radius) {
    this();
    this.radius = radius;
  }
  public static int getCount() {
    return count;
  }
}

public class _17_ConstructorChaining {
  public static void main(String[] args) {
    Circle c1 = new Circle(30);
    Circle c2 = new Circle(35);
    System.out.println("Total Obj of Circle: " + Circle.getCount());
  }
}