// Write a program in Java to demonstrate use of this keyword. Check whether this canaccess
// the Static variables of the class or not. [Refer class student in Q12 to perform the task]


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

    // The static field Student.count should be accessed in a static way
    // System.out.println("Obj count" + this.count);

    // The static method getCount() from the type Student should be accessed in a static way
    // System.out.println("Obj count" + this.getCount());
  }

  public static int getCount() {
    return count;
  }

}


public class _13_This {
  public static void main(String[] args) {
    Student s1 = new Student("MCA23498", "Kishan", "Male");
    Student s2 = new Student("MCA23499", "Sujal", "Male");
    System.out.println("Total Students: " + Student.getCount());
    Student s3 = new Student("MCA23500", "Suresh", "Male");
    System.out.println("Total Students: " + Student.getCount());
  }
}

