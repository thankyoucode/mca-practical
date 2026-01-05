package cpack;
import apack.A;

public class C {
    public void display() {
        A obj = new A();
        System.out.println("C: pub=" + obj.pub);
        // obj.prot;  // ERROR: protected not accessible from different package
        // obj.priv;  // ERROR: private not accessible
        System.out.println("C: Cannot access protected/private variables");
    }
}
