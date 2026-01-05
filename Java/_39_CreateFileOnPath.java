import java.io.File;
import java.io.IOException;

public class _39_CreateFileOnPath {
  public static void main(String[] args) {
    String file_path = "./hello/my.txt";
    File file = new File(file_path);
    try {
      file.createNewFile();
      System.out.println("File is created at " + file_path);
    } catch (IOException e) {
      System.out.println("Please check that full path is exist " + file_path);
      e.printStackTrace();
    }
  }
}

// File is created at ./hello/my.txt