package Manager;

import model.BankAccount;
import model.SavingAccount;
import model.Student;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;
import Utils.StudentUtils;

public class StudentManager {

    private ArrayList<Student> students;
    Scanner sc = new Scanner(System.in);

    public StudentManager(ArrayList<Student> students) {
        this.students = students;
    }

    private String generateAccountNumber() {
        while (true) {
            String id = "ACC-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
            boolean isUnique = true;

            for (Student s : students) {
                if (s.getAccount().getAccountNumber().equalsIgnoreCase(id)) {
                    isUnique = false;
                    break;
                }
            }

            if (isUnique) {
                return id;
            }

        }
    }

    public void addStudent() {
        System.out.print("Enter Your Name: ");
        String name = sc.nextLine().trim();

        System.out.print("Enter Id: ");
        String id = sc.nextLine().trim();

        System.out.print("Enter Grade: ");
        String grade = sc.nextLine().trim();

        // ! Implement Later
        // System.out.print("Enter Account Type (savings/checking): ");
        // String type = sc.nextLine().trim().toLowerCase();

        BankAccount account;
        String accountNumber = generateAccountNumber();

        account = new SavingAccount(accountNumber, 0.0);
        Student student = new Student(id, name, grade, account);
        students.add(student);

        System.out.println("Student added successfuly: " + "\n" + student);
    }

    public void viewStudent() {
        System.out.print("Enter Student Id: ");
        String id = sc.nextLine();

        Student student = StudentUtils.findStudentById(students,id);

        if (student != null) {
            System.out.println(student);
            return;
        } else {
            System.out.println("No Student Found: " + id);
        }
    }

    public void viewStudents() {
        for (Student student : students) {
            System.out.println(student);
        }
    }

    public void updateStudent() {

        System.out.print("Enter STudent Id: ");
        String id = sc.nextLine();

        Student student = StudentUtils.findStudentById(students,id);

        if (student != null) {
            System.out.println(student);

            System.out.print("Enter Updated Id: ");
            student.setId(sc.nextLine().trim());

            System.out.print("Enter Updated Name: ");
            student.setName(sc.nextLine().trim());

            System.out.print("Enter Updated Grade: ");
            student.setGrade(sc.nextLine().trim());

            System.out.println("Student Updated Succesfuly: " + student);
            return;

        }

        System.out.println("No Student Found: " + id);
    }

    public void deleteStudent() {

        System.out.print("Enter Student Id: ");
        String id = sc.nextLine().trim();

        Student student = StudentUtils.findStudentById(students,id);

        if (student != null) {
            System.out.println(student);
            students.remove(student);
            System.out.println("Student Deleted Succesfully");
        } else {
            System.out.println("No student was found with id: " + id);
        }

    }

    // Helper Functions

}
