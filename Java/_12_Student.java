// Create a class “Student” that would contain enrollment No, name, and gender andmarks as
// instance variables and count as static variable which stores the count of the objects;
// constructors and display(). Implement constructors to initialize instance variables. Also
// demonstrate constructor chaining. Create objects of class “Student” and displays all values of
// objects.

class Student {
  private String enrollment, name, gender;
  static protected int count = 0;

  Student(String in_enrollment, String in_name, String in_gender ) {
    enrollment = in_enrollment;
    name = in_name;
    gender = in_gender;
    
    count += 1;

    System.out.println("Student " + count);
    System.out.println("\tEnrollment: " + enrollment);
    System.out.println("\tName: " + name);
    System.out.println("\tGender: " + gender);
    System.out.println();
  }

  public static int getCount() {
    return count;
  }

}

public class _12_Student {
  public static void main(String[] args) {
    Student s1 = new Student("MCA23498", "Kishan", "Male");
    Student s2 = new Student("MCA23499", "Sujal", "Male");
    System.out.println("Total Students: " + Student.getCount());
    Student s3 = new Student("MCA23500", "Suresh", "Male");    
    System.out.println("Total Students: " + Student.getCount());
  }

}
