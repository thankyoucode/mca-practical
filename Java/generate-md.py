import os
import subprocess


def get_program_order():
    """Returns the list of Java programs (in syllabus order)."""
    return [
        "_01_Hello.java",
        "_02_PrimeAndFibonacci.java",
        "_03_IsPalindrome.java",
        "_04_MathPowerUse.java",
        "_05_ArmstrongNumber.java",
        "_06_MinFrom3N.java",
        "_07_MaxFrom4N.java",
        "_08_Multiply2Matrix.java",
        "_09_MatrixAddition.java",
        "_10_Args.java",
        "_11_CountEachCharInstent.java",
        "_12_Student.java",
        "_13_This.java",
        "_14_ConstroctorAndStaticScope.java",
        "_15_StaticExecuteBeforeMain.java",
        "_16_PrimitiveToObj.java",
        "_17_ConstructorChaining.java",
        "_18_MethodOverRiddingClass.java",
        "_19_Inheritence_account_current_saving.java",
        "_20_SuperConstructor.java",
        "_21_Final.java",
        "_22_ClassAxClassBx.java",
        "_23_Abstract.java",
        "_24_Interface.java",
        "_25_StudentExam.java",
        "_26_Package.java",
        "_27_GenericClass.java",
        "_28_StringCase.java",
        "_29_StringMethods.java",
        "_30_FinalClassMethodVeriable.java",
        "_31_zero_division_error.java",
        "_32_throw_try_catch.java",
        "_33_Throws.java",
        "_34_ObjectFileWrite.java",
        "_35_GenericSorter.java",
        "_36_FileCrud.java",
        "_37_StanderdInput.java",
        "_38_FlieExist.java",
        "_39_CreateFileOnPath.java",
        "_40_ReadFile.java",
        "_41_CountLinesInFile.java",
        "_42_GenericCount.java",
        "_43_GenericValueSwap.java",
        "Thread_1_Thread.java",
        "Thread_2_Runable.java",
        "Thread_3_GapTime.java",
        "Thread_4_OddEven.java",
        "Thread_5_ABC.java",
        "Thread_6_sync.java",
        "Collection_1_LinkedListStudent.java",
        "Collection_2_Employee.java",
        "Collection_3_HashMap.java",
        "Collection_4_LinkedListStudentSort.java",
    ]


def get_title_map():
    """Returns the title descriptions for the programs."""
    return {
        "_01_Hello.java": "1. Write a simple 'Hello World' java program, compilation, debugging, executing using java compiler and interpreter.",
        "_02_PrimeAndFibonacci.java": "2. Write a program to pass Starting and Ending limit and print all prime numbers and Fibonacci numbers between this ranges.",
        "_03_IsPalindrome.java": "3. Write a java program to check whether number is palindrome or not. Input: 528 Output: It is not palindrome number. Input: 545 Output: It is palindrome number",
        "_04_MathPowerUse.java": "4. Write a java program to print value of x^n. Input: x=5 Input: n=3 Output: 125",
        "_05_ArmstrongNumber.java": "5. Write a java program to check Armstrong number. Input: 153 Output: Armstrong number. Input: 22 Output: not Armstrong number",
        "_06_MinFrom3N.java": "6. Write a program in Java to find minimum of three numbers using conditional operator.",
        "_07_MaxFrom4N.java": "7. Write a java program which should display maximum number of given 4 numbers.",
        "_08_Multiply2Matrix.java": "8. Write a program in Java to multiply two matrix. Declare a class Matrix where 2D array is declared as instance variable and array should be initialized, within class.",
        "_09_MatrixAddition.java": "9. Write a java program to create a class 'Matrix' that would contain integer values having varied Numbers of columns for each row. Print row-wise sum of the integer values for each row.",
        "_10_Args.java": "10. Write a Java application which takes several command line arguments, which are supposed to be names of students and prints output as given below: (Suppose we enter 3 names then output should be as follows).. Number of arguments = 3 1. First Student Name is = Arun 2. Second Student Name is = Hiren 3. Third Student Name is = Hitesh",
        "_11_CountEachCharInstent.java": "11. Write a Java application to count and display frequency of letters and digits from the String given by user as command-line argument.",
        "_12_Student.java": "12. Create a class 'Student' that would contain enrollment No, name, and gender and marks as instance variables and count as static variable which stores the count of the objects; constructors and display(). Implement constructors to initialize instance variables. Also demonstrate constructor chaining. Create objects of class 'Student' and displays all values of objects.",
        "_13_This.java": "13. Write a program in Java to demonstrate use of this keyword. Check whether this can access the Static variables of the class or not. [Refer class student in Q12 to perform the task]",
        "_14_ConstroctorAndStaticScope.java": "14. Create a class 'Rectangle' that would contain length and width as an instance variable and count as a static variable. Define constructors [constructor overloading (default, parameterized and copy)] to initialize variables of objects. Define methods to find area and to display variables' value of objects which are created. [Note: define initializer block, static initializer block and the static variable and method. Also demonstrate the sequence of execution of initializer block and static initialize block]",
        "_15_StaticExecuteBeforeMain.java": "15. Write a java program static block which will be executed before main() method in a Class.",
        "_16_PrimitiveToObj.java": "16. Write programs in Java to use Wrapper class of each primitive data types.",
        "_17_ConstructorChaining.java": "17. Write a class 'circle' with radius as data member and count the number of instances created using default constructor only. [Constructor Chaining]",
        "_18_MethodOverRiddingClass.java": "18. Create a class 'Vehicle' with instance variable vehicle_type. Inherit the class in a class called 'Car' with instance model_type, company name etc. display the information of the vehicle by defining the display() in both super and sub class [Method Overriding]",
        "_19_Inheritence_account_current_saving.java": "19. Create a class 'Account' containing accountNo, and balance as an instance variable. Derive the Account class into two classes named 'Savings' and 'Current'. The 'Savings' class should contain instance variable named interestRate, and the 'Current' class should contain instance variable called overdraftLimit. Define appropriate methods for all the classes to enable functionalities to check balance, deposit, and withdraw amount in Savings and Current account. [Ensure that the Account class cannot be instantiated.]",
        "_20_SuperConstructor.java": "20. Write a program in Java in which a subclass constructor invokes the constructor of the super class and instantiate the values. [refer class Account and sub classes savingAccount and CurrentAccount in Q 19 for this task]",
        "_21_Final.java": "21. Write a program in Java to demonstrate the use of 'final' keyword in the field declaration. How it is accessed using the objects.",
        "_22_ClassAxClassBx.java": "22. Write a java program to illustrate how to access a hidden variable. Class A declares a static variable x. The class B extends A and declares an instance variable x. display() method in B displays both of these variables.",
        "_23_Abstract.java": "23. Describe abstract class called Shape which has three subclasses say Triangle, Rectangle, and Circle. Define one method area() in the abstract class and override this area() in these three subclasses to calculate for specific object i.e. area() of Triangle subclass should calculate area of triangle etc. Same for Rectangle and Circle",
        "_24_Interface.java": "24. Write a java program to implement an interface called Exam with a method Pass(int mark) that returns a boolean. Write another interface called Classify with a method Division(int average) which returns a String. Write a class called Result which implements both Exam and Classify. The Pass method should return true if the mark is greater than or equal to 50 else false. The Division method must return 'First' when the parameter average is 60 or more, 'Second' when average is 50 or more but below 60, 'No division' when average is less than 50.",
        "_25_StudentExam.java": "25. Assume that there are two packages, student and exam. A student package contains Student class and the exam package contains Result class. Write a program that generates mark sheet for students.",
        "_26_Package.java": "26. Define a class A in package apack. In class A, three variables are defined of access modifiers protected, private and public. Define class B in package bpack which extends A and write display method which accesses variables of class A. Define class C in package cpack which has one method display() in that create one object of class A and display its variables. Define class ProtectedDemo in package dpack in which write main() method. Create objects of class B and C and class display method for both these objects.",
        "_27_GenericClass.java": "27. Write a java program to implement Generic class Number_1 for both data type int and float in java.",
        "_28_StringCase.java": "28. Write a java program to accept string to check whether it is in Upper or Lower case. After checking, case will be reversed.",
        "_29_StringMethods.java": "29. Write a java program to use important methods of String class.",
        "_30_FinalClassMethodVeriable.java": "30. Write a program in Java to demonstrate use of final class, final variable and final method",
        "_31_zero_division_error.java": "31. Write a program in Java to develop user defined exception for 'Divide by Zero' error",
        "_32_throw_try_catch.java": "32. Write a program in Java to demonstrate throw, throws, finally, multiple try block and multiple catch exception.",
        "_33_Throws.java": "33. Write a small application in Java to develop Banking Application in which user deposits the amount Rs 1000.00 and then start withdrawing of Rs 400.00, Rs 300.00 and it throws exception 'Not Sufficient Fund' when user withdraws Rs. 500 thereafter.",
        "_34_ObjectFileWrite.java": "34. Write a program to write at least 10 objects of the Circle class in a File and to perform basic operations: adding, retrieving, updating, removing elements.",
        "_35_GenericSorter.java": "35. Write a program for Java Generics class for Sorting operations: 1. Sorting a list according to natural ordering of elements 2. Reversing sort order 3. Sorting a list whose elements of a custom type 4. Sorting a list using a Comparator. [desirable]",
        "_36_FileCrud.java": "36. Write a program in Java to create, write, modify, read operations on a Text file.",
        "_37_StanderdInput.java": "37. Write a java program to illustrate use of standard input stream to read the user input.",
        "_38_FlieExist.java": "38. Write a java program to checks the existence of a specified file.",
        "_39_CreateFileOnPath.java": "39. Write a java program to create a file to the specified location.",
        "_40_ReadFile.java": "40. Write a java program to demonstrate the way contents are read from a file.",
        "_41_CountLinesInFile.java": "41. Write a java program to count the availability of text lines in the particular file. A file is read before counting lines of a particular file.",
        "_42_GenericCount.java": "42. Write a generic method to count the number of elements in a collection that have a specific property (for example, odd integers, prime numbers, palindromes).",
        "_43_GenericValueSwap.java": "43. Write a generic method to exchange the positions of two different elements in an array.",
        "Thread_1_Thread.java": "Thread 1. Write a program to implement the concept of threading by extending 'Thread' Class.",
        "Thread_2_Runable.java": "Thread 2. Write a program to implement the concept of threading by implementing 'Runnable' Interface.",
        "Thread_3_GapTime.java": "Thread 3. Write a program that executes two threads. One thread displays 'Thread1' every 2,000 milliseconds, and the other displays 'Thread2' every 4,000 milliseconds.",
        "Thread_4_OddEven.java": "Thread 4. Write a program that executes two threads. One thread will print the even numbers and another thread will print odd numbers from 1 to 50.",
        "Thread_5_ABC.java": "Thread 5. Write java program that create and runs following threads: a) print 'A' 20 times b) print 'B' 30 times c) print 'C' 15 times",
        "Thread_6_sync.java": "Thread 6. Write a program in Java to demonstrate use of synchronization of threads when multiple threads are trying to update common variable for 'Account' class.",
        "Collection_1_LinkedListStudent.java": "Collection 1. Develop a program to create Linked List for 'Student' class objects references. 'Student' class has std_id, std_name, Array of marks, total_marks. Calculate total_marks for all students of Linked List. Display Linked List and also display a particular student based on student name as a command line argument.",
        "Collection_2_Employee.java": "Collection 2. Develop a program to create Array List for 'Employee' class objects references. Employee class has emp_code, emp_name, basic_sal, gross_sal. Calculate gross_sal for all employees of Array List. Display Array List and also insert an employee object reference in a particular position (input) in Array List. Gross_sal=basic_sal+20% of basic_sal (MA)+30% of basic_sal(HRA)",
        "Collection_3_HashMap.java": "Collection 3. Develop a program to create Hash Map for 'Customer' class objects references. Customer class has Bill_no, cust_mobile_no, Array of item_name, Array of item_unit_price, Array of item_count, total_price. Calculate total_price for all customers of Hash Map. Display Hash Map and also search particular customer's bill based on customer mobile no. Key is mobile no.",
        "Collection_4_LinkedListStudentSort.java": "Collection 4. Sort 'Student' Linked List (mentioned in Q:1) based on std_name using 'Comparator' interface",
    }


def run_java(java_file):
    try:
        compile_proc = subprocess.run(
            ["javac", java_file], capture_output=True, text=True
        )
        if compile_proc.returncode != 0:
            return ""

        run_proc = subprocess.run(
            ["java", os.path.splitext(java_file)[0]],
            capture_output=True,
            text=True,
            timeout=5,
        )
        return run_proc.stdout.strip()
    except Exception:
        return ""


def generate_markdown():
    programs = get_program_order()
    titles = get_title_map()

    md = []

    md.append("# Object Oriented Programming Using Java\n\n")
    md.append("Program Name: Master of Computer Applications\n")
    md.append("Course Code: MC01094041\n")
    md.append("Course Name: Object Oriented Programming using JAVA\n\n")

    for index, file in enumerate(programs, start=1):
        title = titles.get(file, file)

        md.append(f"{title}\n")

        if os.path.exists(file):
            with open(file, "r", encoding="utf-8") as f:
                code = f.read()
        else:
            code = ""

        output = run_java(file)

        md.append("```java\n")
        md.append(code)
        md.append("\n```\n")

        md.append("```plaintext\n")
        md.append(output)
        md.append("\n```\n\n")

    return "".join(md)


def main():
    content = generate_markdown()
    with open("java-programs.md", "w", encoding="utf-8") as f:
        f.write(content)


if __name__ == "__main__":
    main()
