// Create a class “Rectangle” that would contain length and width as an instance variable and
// count as a static variable.
// Define constructors [constructor overloading (default, parameterized and copy)] to
// initialize variables of objects. Define methods to find area and to display variables’ value of
// objects which are created.
// [Note: define initializer block, static initializer block and the static variable and method. Also
// demonstrate the sequence of execution of initializer block and static initialize block]

class Rectangle {
  public double length, width;
  protected static int count=0;
  // default constructor
  Rectangle() {
    count++;
  }
  // parameterized constructor
  Rectangle(double length, double width) {
    this();
    this.length = length;
    this.width = width;
  }
  // copy constructor
  Rectangle(Rectangle rec) {
    this();
    this.length = rec.length;
    this.width = rec.width;
  }

  public static int getCount() {
    return count;
  }

  public double area() {
    return length * width;
  }

  public void display() {
    System.out.println("Length: "+ length +" , Width: "+ width +", Area: " + area());
  }
}


public class _14_ConstroctorAndStaticScope {
  // static initialize block - always run first on program start
  static {
    System.out.println("static initializer block");
  }
  public static void main(String[] args) {
    // initializer block in in side main method
    {
      System.out.println("initializer block");
    }
    Rectangle defalut_rec = new Rectangle();
    defalut_rec.length = 2030;
    defalut_rec.length = 750;
    defalut_rec.display();
    Rectangle pre_rec = new Rectangle(734, 402.34); // best way as i think - clearn code
    pre_rec.display();
    Rectangle copy_rec = new Rectangle(pre_rec);
    copy_rec.display();
    System.out.println("Total Rectangle Obj created: " + Rectangle.getCount());
  }
}
