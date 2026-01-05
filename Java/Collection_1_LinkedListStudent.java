import java.util.LinkedList;

class Student {
  int id, marks[], total_marks;
  String name;

  static int sum(int[] marks) {
    int total = 0;
    for(int mark: marks) {
      total += mark;
    }
    return total;
  }

  Student(int id, String name, int[] marks) {
    this.id = id;
    this.name = name;
    this.marks = marks;
    this.total_marks = sum(this.marks);
  }
}

public class Collection_1_LinkedListStudent {

  static void display(LinkedList<Student> stds) {
    for (Student std : stds) {
      System.out.println("Id: " + std.id + " Name: " + std.name + " Total Marks: " + std.total_marks);
    }
  }

  public static void main(String args[]) {
    Student a = new Student(1, "Sujal", new int[] {60, 80, 91});
    Student b = new Student(2, "Bharat", new int[] {60, 80, 92});
    Student c = new Student(3, "Krisna", new int[] {60, 80, 93});

    LinkedList<Student> students = new LinkedList<Student>();

    students.add(a);
    students.add(b);
    students.add(c);

    display(students);
  }
}

// Id: 1 Name: Sujal Total Marks: 231
// Id: 2 Name: Bharat Total Marks: 232
// Id: 3 Name: Krisna Total Marks: 233
