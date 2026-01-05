// Write a java program to illustrate how to access a hidden variable. Class A declaresa static
// variable x. The class B extends A and declares an instance variable x. display( ) method in B
// displays both of these variables.

class A {
  public int x;
}
class B extends A {
  public int x;

  public void setSuperX(int x) {
    super.x = x;
  }
  public void display() {
    System.out.println("Ax: " + x + ", Bx: " + super.x);
  }
}


public class _22_ClassAxClassBx {
  public static void main(String[] args) {
    B myb = new B();
    myb.x = 10;
    myb.setSuperX(20);
    myb.display();
  }
}
