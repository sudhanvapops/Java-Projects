import java.util.ArrayList;
import java.util.Scanner;

import Manager.BankManager;
import Manager.LibraryManager;
import Manager.StudentManager;
import model.Library;
import model.Student;

public class Main {
    public static void main(String[] args) {
        
        ArrayList<Student> students = new ArrayList<>();
        Library l1 = new Library();

        Scanner sc = new Scanner(System.in);

        StudentManager sm = new StudentManager(students);
        BankManager bm = new BankManager(sm,students);
        LibraryManager lm = new LibraryManager(students,sm,l1);


        // ? Testing Codes
        lm.testAddBook();
        sm.testAddStudents();


        while (true) {
            System.out.println("\n===== Campus Management Menu =====");

            System.out.println("1. Add Student");
            System.out.println("2. View Student");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. View All Students");
            
            System.out.println("6. Deposit Money");
            System.out.println("7. Withdraw Money");
            System.out.println("8. View Balance");
            System.out.println("9. Transfer Money");
            
            
            System.out.println("10. Add Book");
            System.out.println("11. View All Books");
            System.out.println("12. Remove Book");
            System.out.println("13. Update Book");

            System.out.println("14. Borrow Book");
            System.out.println("15. Return Book");

            System.out.println("0. Exit");
            // Adding Books and all those still remain
            // And only admin can depoisit money

            System.out.println("\n==================================\n");
            System.out.print("Enter your choice: ");

            
            try {
                Integer choice = sc.nextInt();
                sc.nextLine();
                switch (choice) {
                    case 1 -> sm.addStudent();
                    case 2 -> sm.viewStudent();
                    case 3 -> sm.updateStudent();
                    case 4 -> sm.deleteStudent();
                    case 5 -> sm.viewStudents();
                    
                    case 6 -> bm.depositMoney();
                    case 7 -> bm.withDrawMoney();
                    case 8 -> bm.showBalance();
                    case 9 -> bm.transferMoney();
                    
                    case 10 -> lm.addBook();
                    case 11 -> lm.viewAllBooks();
                    case 12 -> lm.removeBook();
                    case 13 -> lm.updateBook();

                    case 14 -> lm.borrowBook();

                    case 0 -> System.exit(0);
                }
    
            } catch (Exception e) {
                System.out.println("Exception "+e);
                System.out.println("Please choose a correct option");
                sc.nextLine();
            }
        }

    }
}
