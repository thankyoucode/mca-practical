// Describe abstract class called Shape which has three subclasses say Triangle, Rectangle, and
// Circle. Define one method area () in the abstract class and override this area () in these three
// subclasses to calculate for specific object i.e. area () of Triangle subclass should calculate area
// of triangle etc. Same for Rectangle and Circle

abstract class Shape {
  abstract public double area();
}

class Circle extends Shape {
  public double r;
  public Circle(double r) {
    this.r = r;
  }
  public double area() {
    return Math.PI * Math.sqrt(r);
  }
}
class Rectangle extends Shape {
  public double l, b;
  public Rectangle(double l, double b) {
    this.l = l;
    this.b = b;
  }
  public double area() {
    return l * b;
  }
}
class Triangle extends Shape {
  public double b, h;
  public Triangle(double b, double h) {
    this.b = b;
    this.h = h;
  }
  public double area() {
    return Math.PI * Math.sqrt((h*b)/2);
  }
}

public class _23_Abstract {
  public static void main(String[] args) {
    Circle circle = new Circle(20);
    System.out.println(circle.area());

    Rectangle rectangle = new Rectangle(20, 30);
    System.out.println(rectangle.area());

    Triangle triangle = new Triangle(20, 30);
    System.out.println(triangle.area());
  }
}
