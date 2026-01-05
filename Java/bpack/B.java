package bpack;
import apack.A;

public class B extends A {
    public void display() {
        System.out.println("B (extends A): pub=" + pub + ", prot=" + prot);
    }
}
