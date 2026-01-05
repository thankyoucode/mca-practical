// 2. Develop a program to create Array List for “Employee” class objects references. Employee
// class has emp_code, emp_name, basic_sal, gross_ sal. Calculate gross_sal for all employees of
// Array List. Display Array List and also insert an employee object reference in a particular
// position (input) in Array List.
// Gross_sal=basic_sal+20% of basic_sal (MA)+30% of basic_sal(HRA)

import java.util.ArrayList;

class Employee {
  int code;
  String name;
  double basic_sal, gross_sal;

  public Employee(int code, String name, double basic_sal) {
    this.code = code;
    this.name = name;
    this.basic_sal = basic_sal;
    this.gross_sal = grossSal(basic_sal);
  }

  public static double grossSal(double basic_sal) {
    // gross_sal = 20% MA + 30% HRA
    return basic_sal + (basic_sal * 0.2) + (basic_sal * 0.3);
  }
}

public class Collection_2_Employee {

  static void display(ArrayList<Employee> emps) {
    for (Employee emp : emps) {
      System.out.println("Id: " + emp.code  + "  Name: " + emp.name  + "  Gross salary: " +  emp.gross_sal);
    }
  }
  public static void main(String[] args) {
    ArrayList<Employee> emps = new ArrayList<>();

    emps.add(new Employee(1001, "Bhargav", 60000));
    emps.add(new Employee(1002, "Sujal", 90000));
    emps.add(new Employee(1003, "Asmita", 30000));
    emps.add(new Employee(1003, "Asmita", 25000));

    emps.add(2, new Employee(1111, "Haresh", 120000));

    display(emps);
  }
}
