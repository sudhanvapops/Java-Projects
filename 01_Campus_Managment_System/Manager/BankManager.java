package Manager;

import java.util.ArrayList;
import java.util.Scanner;

import Utils.SearchUtils;
import model.Student;

public class BankManager {

    private ArrayList<Student> students;
    Scanner sc = new Scanner(System.in);

    public BankManager(ArrayList<Student> students) {
        this.students = students;
    }

    public void depositMoney() {
        System.out.print("Enter Student Id: ");
        String id = sc.nextLine().trim();

        Student student = SearchUtils.findStudentByKey(id, students);

        if (student != null) {
            System.out.print("Enter amount to deposit: ");
            try {
                double amount = sc.nextDouble();
                sc.nextLine(); // Consume newline
                double balance = student.getAccount().getBalance();
                student.getAccount().setBalance(balance + amount);

                System.out.println("Deposit successful!, Balance: " + student.getAccount().getBalance());

            } catch (Exception e) {
                System.out.println("DEBUG: Error during deposit - " + e.getMessage());
                sc.nextLine(); // Clear the scanner
            }
        } else {
            System.out.println("Student not Found.");
        }
    }

    public void withDrawMoney() {

        System.out.print("Enter Student Id: ");
        String id = sc.nextLine().trim();

        Student student = SearchUtils.findStudentByKey(id, students);

        if (student != null) {
            System.out.println("Student Found");
            System.out.println("Balance: " + student.getAccount().getBalance());

            System.out.print("Enter amount to Withdraw: ");
            try {
                double amount = sc.nextDouble();
                sc.nextLine();
                withdraw(amount, student);

            } catch (Exception e) {
                e.printStackTrace();
                sc.nextLine(); // Clear the scanner
            }
        } else {
            System.out.println("Student Not Found");
        }
    }

    // Helper Function to Withdraw
    private void withdraw(double amount, Student student) {
        double rBalance = student.getAccount().getBalance() - amount;
        if (rBalance > 0) {
            student.getAccount().setBalance(rBalance);
        } else {
            System.out.println("Not enough Money ");
        }
    }

    // Function to view Balance
    public void showBalance() {
        System.out.println("Enter Id: ");
        String id = sc.nextLine();
        Student student = SearchUtils.findStudentByKey(id, students);

        if (student != null) {
            System.out.println("Balance: " + student.getAccount().getBalance());
        } else {
            System.out.println("No Student Found");
        }

    }

    // Transfering Money
    public void transferMoney() {
        try {
            System.out.print("Enter Your Acc number: ");
            String accNumber1 = sc.nextLine();

            System.out.print("Enter Acc number to Transfer Money: ");
            String accNumber2 = sc.nextLine();

            System.out.print("Enter Ammount to transfer: ");
            double moneyTrans = sc.nextDouble();
            sc.nextLine();

            Student studentFrom = SearchUtils.findStudentByKey(accNumber1, students);

            Student studentTo = SearchUtils.findStudentByKey(accNumber2, students);

            if (studentFrom != null && studentTo != null) {
                double studentFromBalance = studentFrom.getAccount().getBalance();
                double studentToBalance = studentTo.getAccount().getBalance();

                if (studentFromBalance >= moneyTrans) {
                    studentFrom.getAccount().setBalance(studentFromBalance - moneyTrans);
                    studentTo.getAccount().setBalance(studentToBalance + moneyTrans);

                    System.out.println(
                            "Name: " + studentFrom.getName() + "Balance: " + studentFrom.getAccount().getBalance());
                    System.out.println(
                            "Name: " + studentTo.getName() + "Balance: " + studentTo.getAccount().getBalance());

                } else {
                    System.out.println("Balnce Not Sufficient: " + studentFromBalance);
                }
            } else {
                System.out.println("Student Not Found");
            }

        } catch (Exception e) {

        }
    }

}