class Exam {
  String exam_name;
  int subject_totalmark;
  private String subjects[];

  Exam(String exam_name_in, int subject_totalmark_in,String subjects_in[]) {
    exam_name = exam_name_in;
    subjects = subjects_in;
    subject_totalmark = subject_totalmark_in;
  }

  public void info() {
    System.out.println("Exam: " + exam_name);
    System.out.println("Subjects: ");
    for (String subject : subjects) {
      System.out.println("\t- " + subject);
    }
  }

  static int sum(int marks[]) {
    int total = 0;
    for (int mark : marks) {
      total += mark;
    }
    return total;
  }

  static String gread(float percentage) {
    if(percentage > 80) {
      return "A";
    } else if(percentage >= 70) {
      return "B";
    } else if(percentage >= 60) {
      return "C";
    } else if(percentage >= 50) {
      return "D";
    } else if(percentage >= 33) {
      return "E";
    } else {
      return "RED F (FAIL)";
    }
  }

  protected void Result(int marks[]) {
    if (subjects.length != marks.length) { 
      System.out.println("Need same marks as number of subjects");
      return; 
    }

    for (int mark : marks) {
      if(mark > subject_totalmark) {
        System.out.println("This mark is not valid: " + mark);
      }
    }

    int total = sum(marks);
    float percentage = (total / (float)(marks.length * subject_totalmark) * 100);

    System.out.println("Exam: " + exam_name);

    System.out.println("-------------------------------");
    System.out.println("Subject \t| Marks (" + subject_totalmark + ")");
    System.out.println("...............................");
    for(int i=0; i < subjects.length; i ++) {
      System.out.println( subjects[i]  + " \t\t| " + marks[i]);
    }
    System.out.println("-------------------------------");

    System.out.println("Total\t\t| " + total);
    System.out.println("Percentage: " + percentage);
    System.out.println("Gread: " + gread(percentage));
    System.out.println("===============================\n");
  }

}

class Student extends Exam {
  String name;
  int roll_no;
  int marks[];
  Student(String name_in, int roll_no_in, String exam_name_in, int subject_totalmark_in, String subjects_in[], int marks_in[]) {
    super(exam_name_in, subject_totalmark_in, subjects_in);
    name = name_in;
    roll_no = roll_no_in;
    marks = marks_in;
  }

  void student_info() {
    System.out.println("\n===============================");
    System.out.println("Student Name: " + name);
    System.out.println("Roll No.: " + roll_no);
    System.out.println("-------------------------------");
  }

  void getMyResult() {
    student_info();
    Result(marks);
  }
}

public class _25_StudentExam {
  public static void main(String[] args) {
    String subjects[] = {"C", "JAVA"};
    int marks[] = {68, 69};
    
    Student me = new Student("Kishan", 12, "Internal MCA Exam", 70, subjects, marks);

    me.getMyResult();
  }
}