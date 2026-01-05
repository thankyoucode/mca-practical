import java.util.Dictionary;
import java.util.Enumeration;
import java.util.Hashtable;

public class _11_CountEachCharInstent {
  public static void main(String args[]) {

    Dictionary<Character, Integer> dict = new Hashtable<>();

    String name = args[0];

    System.out.println("String is : " + name);

    int name_len = name.length();


    for(int i = 0; i < name_len; i++) {
      char a_char = name.charAt(i);
      if (dict.get(a_char) == null) {
        dict.put(a_char, 1);
      } else {
        dict.put(a_char, dict.get(a_char) + 1);
      }
    }

    for(Enumeration<Character> e = dict.keys(); e.hasMoreElements();) {
      char a_char = e.nextElement();
      System.out.println(a_char + " - " + dict.get(a_char));
    }
  }
}