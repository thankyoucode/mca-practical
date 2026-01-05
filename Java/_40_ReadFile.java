import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class _40_ReadFile {
public static void main(String[] args) {
    File file = new File("my.txt");
    try {
      file.createNewFile();
      FileWriter file_writer = new FileWriter(file);
      file_writer.write("Hello from this my.txt file");
      file_writer.close();

      // READ FILE
      FileReader reader = new FileReader(file);
      BufferedReader br = new BufferedReader(reader);

      String line;
      while ((line = br.readLine()) != null) {
          System.out.println(line);
      }

      br.close();
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

}
