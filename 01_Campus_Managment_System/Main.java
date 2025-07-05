import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import Data.UserData;
import Manager.BankManager;
import Manager.LibraryManager;
import Manager.StudentManager;
import Utils.PermissionConfig;
import model.Library;
import model.Role;
import model.Student;
import model.User;

public class Main {

    public static void main(String[] args) {

        ArrayList<Student> students = new ArrayList<>();
        Library l1 = new Library();

        Scanner sc = new Scanner(System.in);

        StudentManager sm = new StudentManager(students);
        BankManager bm = new BankManager(students);
        LibraryManager lm = new LibraryManager(students,l1);

        Map<String, User> userDataMap = UserData.userMap;
        Map<Role, List<Integer>> permissionsMap = PermissionConfig.getPermissionMap();

        // ? Testing Codes
        lm.testAddBook();
        sm.testAddStudents();

        while (true) {

            System.out.print("Enter Your username: ");
            String userName = sc.nextLine().trim().toLowerCase();

            if (!userDataMap.containsKey(userName)) {
                System.out.println("User not found. Please try again.\n");
                continue;
            }

            System.out.print("Enter Your Password: ");
            String userPassword = sc.nextLine().trim();

            if (!userDataMap.get(userName).getPassword().equals(userPassword)) {
                System.out.println("Password is incorrect please try again");
                continue;
            }

            User currentUser = userDataMap.get(userName);
            Role currentRole = currentUser.getRole();

            List<Integer> allowedOptions = permissionsMap.get(currentRole);

            System.out.println("Logged in as" + currentUser.getUserName() + " Role: [ " + currentRole.name() + " ]");

            Map<Integer, Runnable> actionMap = Map.ofEntries(
                    Map.entry(1, () -> sm.addStudent()),
                    Map.entry(2, () -> sm.viewStudent()),
                    Map.entry(3, () -> sm.updateStudent()),
                    Map.entry(4, () -> sm.deleteStudent()),
                    Map.entry(5, () -> sm.viewStudents()),
                    Map.entry(6, () -> bm.depositMoney()),
                    Map.entry(7, () -> bm.withDrawMoney()),
                    Map.entry(8, () -> bm.showBalance()),
                    Map.entry(9, () -> bm.transferMoney()),
                    Map.entry(10, () -> lm.addBook()),
                    Map.entry(11, () -> lm.viewAllBooks()),
                    Map.entry(12, () -> lm.removeBook()),
                    Map.entry(13, () -> lm.updateBook()),
                    Map.entry(14, () -> lm.borrowBook()),
                    Map.entry(15, () -> lm.returnBook()));

            Map<Integer, String> menuText = Map.ofEntries(
                    Map.entry(1, "Add Student"),
                    Map.entry(2, "View Student"),
                    Map.entry(3, "Update Student"),
                    Map.entry(4, "Delete Student"),
                    Map.entry(5, "View All Students"),
                    Map.entry(6, "Deposit Money"),
                    Map.entry(7, "Withdraw Money"),
                    Map.entry(8, "View Balance"),
                    Map.entry(9, "Transfer Money"),
                    Map.entry(10, "Add Book"),
                    Map.entry(11, "View All Books"),
                    Map.entry(12, "Remove Book"),
                    Map.entry(13, "Update Book"),
                    Map.entry(14, "Borrow Book"),
                    Map.entry(15, "Return Book"),
                    Map.entry(99, "Logout"),
                    Map.entry(0, "Exit"));

            while (true) {
                System.out.println("\n===== Menu [" + currentRole + "] =====");
                for (Integer key : allowedOptions) {
                    System.out.println(key + ". " + menuText.get(key));
                }
                System.out.println("99. Logout");
                System.out.println("0. Exit");
                System.out.println("==================================");
                System.out.print("\nEnter your choice: ");

                try {
                    int choice = sc.nextInt();
                    sc.nextLine();
                    System.out.flush();

                    if (choice == 0){
                        sc.close();
                        System.exit(0);
                    }
                       
                    if (choice == 99)
                        break;

                    if (!allowedOptions.contains(choice)) {
                        System.out.println("You dont Have Permision for this option");
                    }

                    Runnable action = actionMap.get(choice);
                    if (action != null) {
                        action.run();
                    } else {
                        System.out.println("Invalid Option");
                    }

                } catch (Exception e) {
                    System.out.println("Exception: \n" + e);
                    System.out.println("Input Invalid, Try Agian");
                }

            }
        }

    }
}
