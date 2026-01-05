package dpack;
import bpack.B;
import cpack.C;

public class ProtectedDemo {
    public static void main(String[] args) {
        System.out.println("=== Access Modifier Demo ===\n");
        new B().display();
        System.out.println();
        new C().display();
    }
}
