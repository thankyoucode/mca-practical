import java.util.*;
import java.util.function.Predicate;

public class _42_GenericCount {

    // Generic method
    public static <T> int count(Collection<T> c, Predicate<T> p) {
        int cnt = 0;
        for (T item : c) {
            if (p.test(item)) {
                cnt++;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);

        int oddCount = count(list, x -> x % 2 != 0);

        System.out.println("Odd numbers count: " + oddCount);
    }
}
