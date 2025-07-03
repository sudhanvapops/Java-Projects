import java.util.ArrayList;

public class Student {

    String id;
    String name;
    String grade;

    BankAccount bankAccountNumber;
    ArrayList<Book> borrowedBooks = new ArrayList<>();
    public Student(String id, String name, String grade, BankAccount bankAccountNumber, ArrayList<Book> borrowedBooks) {
        this.id = id;
        this.name = name;
        this.grade = grade;
        this.bankAccountNumber = bankAccountNumber;
        this.borrowedBooks = borrowedBooks;
    }

}
