import java.util.ArrayList;
import java.util.Scanner;

import Manager.StudentManager;
import model.Library;
import model.Student;

public class Main {
    public static void main(String[] args) {
        
        ArrayList<Student> students = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        StudentManager sm = new StudentManager(students);
        // LibraryManager lm = new LibraryManager(new Library());
        // BankManager bm = new BankManager(sm);



        while (true) {
            System.out.println("\n===== Campus Management Menu =====");

            System.out.println("1. Add Student");
            System.out.println("2. View Student");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            
            System.out.println("5. Deposit Money");
            System.out.println("6. Withdraw Money");
            System.out.println("7. Transfer Money");
            
            System.out.println("8. Borrow Book");
            System.out.println("9. Return Book");
            System.out.println("0. Exit");
            // Adding Books and all those still remain
            System.out.println("\n==================================\n");
            System.out.print("Enter your choice: ");

            Integer choice = sc.nextInt();

            switch (choice) {
                case 1 -> sm.addStudent();
                case 2 -> sm.viewStudents();
                // case 3 -> lm.borrowBook(...);
                case 0 -> System.exit(0);
            }

        }

    }
}
