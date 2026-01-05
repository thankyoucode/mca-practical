public class _43_GenericValueSwap {
    // Generic method to swap elements
    public static <T> void swap(T[] array, int i, int j) {
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {

        Integer[] numbers = {1, 2, 3, 4};
        swap(numbers, 0, 2);

        for (Integer n : numbers) {
            System.out.print(n + " ");
        }
    }
}
