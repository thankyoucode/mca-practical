// Write a program in Java to create, write, modify, read operations on a Text file.

import java.io.*;

public class _36_FileCrud {

    public static void main(String[] args) {

        try {
            // CREATE FILE
            File file = new File("36_hello.txt");
            file.createNewFile();

            // WRITE TO FILE
            FileWriter writer = new FileWriter(file);
            writer.write("Hello World");
            writer.close();

            // MODIFY FILE (overwrite content)
            FileWriter modify = new FileWriter(file);
            modify.write("File Modified Successfully");
            modify.close();

            // READ FILE
            FileReader reader = new FileReader(file);
            BufferedReader br = new BufferedReader(reader);

            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

            br.close();

        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
}
