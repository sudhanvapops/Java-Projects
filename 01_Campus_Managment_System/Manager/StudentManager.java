package Manager;

import model.BankAccount;
import model.SavingAccount;
import model.Student;
import java.util.ArrayList;
import java.util.Scanner;
import Utils.StudentUtils;

public class StudentManager {

    private ArrayList<Student> students;
    Scanner sc = new Scanner(System.in);

    public StudentManager(ArrayList<Student> students) {
        this.students = students;
    }

    // ? Test Function

    public void testAddStudents(){
        
        students.add(new Student("Test-001", "Sudhanva S", "Btech 2nd Sem", new SavingAccount("Test-1", 0)));
        students.add(new Student("Test-002", "Punitha V", "Btech 2nd Sem", new SavingAccount("Test-2", 0)));
        students.add(new Student("Test-003", "Adithya Kalluriya", "Btech 2nd Sem", new SavingAccount("Test-3", 0)));
        students.add(new Student("Test-004", "Vinya H G", "Btech 2nd Sem", new SavingAccount("Test-4", 0)));

        
    }

    public void addStudent() {
        System.out.print("Enter Your Name: ");
        String name = sc.nextLine().trim();

        System.out.print("Enter Grade: ");
        String grade = sc.nextLine().trim();

        if (!(name.equalsIgnoreCase("") || grade.equalsIgnoreCase(""))) {
            BankAccount account;
            String accountNumber = "ACC-" + StudentUtils.generateUniqueId(students);

            account = new SavingAccount(accountNumber, 0.0);

            String id = "4VMIS" + StudentUtils.generateUniqueId(students);

            Student student = new Student(id, name, grade, account);
            students.add(student);

            System.out.println("Student added successfuly: " + "\n" + student);
        }else{
            System.out.println("Fileds cannot be Empty !!");
        }

        // ! Implement Later
        // System.out.print("Enter Account Type (savings/checking): ");
        // String type = sc.nextLine().trim().toLowerCase();

    }

    public void viewStudent() {
        System.out.print("Enter Student Id: ");
        String id = sc.nextLine();

        Student student = StudentUtils.findStudentById(students, id);

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

        Student student = StudentUtils.findStudentById(students, id);

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

        Student student = StudentUtils.findStudentById(students, id);

        if (student != null) {
            System.out.println(student);
            students.remove(student);
            System.out.println("Student Deleted Succesfully");
        } else {
            System.out.println("No student was found with id: " + id);
        }

    }

}
