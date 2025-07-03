package Manager;

import model.BankAccount;
import model.SavingAccount;
import model.Student;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;

public class StudentManager {

    public StudentManager(ArrayList<Student> students) {
        this.students = students;
    }

    Scanner sc = new Scanner(System.in);

    private ArrayList<Student> students;

    private String generateAccountNumber() {
        while (true) {
            String id = "ACC-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
            boolean isUnique = true;

            for (Student s : students) {
                if (s.getId().equalsIgnoreCase(id)) {
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
        String name = sc.nextLine();

        System.out.print("Enter Id: ");
        String id = sc.nextLine();

        System.out.print("Enter Grade: ");
        String grade = sc.nextLine();

        // ! Implement Later
        // System.out.print("Enter Account Type (savings/checking): ");
        // String type = sc.nextLine().trim().toLowerCase();

        BankAccount account;
        String accountNumber = generateAccountNumber();

        account = new SavingAccount(accountNumber, 0.0);
        students.add(new Student(id, name, grade, account));
    }

    public void viewStudents(){
        for (Student student : students) {
            System.out.println(student);
        }
    }
}
