// Write a program for Java Generics class for Sorting operations:
// 1. Sorting a list according to natural ordering of elements
// 2. Reversing sort order
// 3. Sorting a list whose elements of a custom type
// 4. Sorting a list using a Comparator. [desirable]
// Custom class for sorting demonstration - implements Comparable


import java.util.*;

// Custom type that implements Comparable
class Student implements Comparable<Student> {
    String name;
    int age;
    
    Student(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    public int compareTo(Student other) {
        return this.age - other.age;
    }
    
    public String toString() {
        return name + "(" + age + ")";
    }
}

// Restrict T to types that implement Comparable
public class _35_GenericSorter<T extends Comparable<T>> {
    List<T> list = new ArrayList<>();
    
    public void add(T item) {
        list.add(item);
    }
    
    // 1. Natural ordering
    public void sortNatural() {
        Collections.sort(list);
        System.out.println("1. Natural: " + list);
    }
    
    // 2. Reverse order
    public void sortReverse() {
        Collections.sort(list, Collections.reverseOrder());
        System.out.println("2. Reverse: " + list);
    }
    
    // 4. Comparator
    public void sortWithComparator(Comparator<T> comp) {
        Collections.sort(list, comp);
        System.out.println("4. Comparator: " + list);
    }
    
    public static void main(String[] args) {
        // Works for Integer, String, and any class implementing Comparable
        _35_GenericSorter<Integer> nums = new _35_GenericSorter<>();
        nums.add(5); nums.add(1); nums.add(3);
        nums.sortNatural();
        nums.sortReverse();
        
        _35_GenericSorter<Student> students = new _35_GenericSorter<>();
        students.add(new Student("Bob", 22));
        students.add(new Student("Alice", 20));
        students.add(new Student("Charlie", 19));
        students.sortNatural();
        students.sortWithComparator(Comparator.comparing(s -> s.name));
    }
}

// Output
// 1. Natural: [1, 3, 5]
// 2. Reverse: [5, 3, 1]
// 1. Natural: [Charlie(19), Alice(20), Bob(22)]
// 4. Comparator: [Alice(20), Bob(22), Charlie(19)]
