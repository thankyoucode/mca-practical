import java.io.*;
public class _41_CountLinesInFile {

    public static void main(String[] args) throws Exception {

        FileReader fr = new FileReader("36_hello.txt");
        BufferedReader br = new BufferedReader(fr);

        int count = 0;
        while (br.readLine() != null) {
            count++;
        }

        br.close();
        System.out.println("Number of lines: " + count);
    }
}