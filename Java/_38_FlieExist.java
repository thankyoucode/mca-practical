import java.io.File;

public class _38_FlieExist {
  public static void main(String[] args) {
    File file = new File("36_hello.txt");

    if(file.exists()) {
      System.out.println("This file is exists");
    } else {
      System.out.println("This file is not exists");
    }
  }
}
