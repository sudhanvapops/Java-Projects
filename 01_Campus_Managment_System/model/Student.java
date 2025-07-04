package model;
import java.util.ArrayList;

public class Student {

    String id;
    String name;
    String grade;

    public BankAccount account;
    public ArrayList<Book> borrowedBooks = new ArrayList<>();


    public ArrayList<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    public void setBorrowedBooks(ArrayList<Book> borrowedBooks) {
        this.borrowedBooks = borrowedBooks;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public BankAccount getAccount() {
        return account;
    }

    
    public Student(String id, String name, String grade, BankAccount account) {
        this.id = id;
        this.name = name;
        this.grade = grade;
        this.account = account;
    }

    @Override
    public String toString() {
        return "Student { id: " + id + ", name: " + name + ", grade: " + grade + ", account: " + account + ", borrowedBooks: "
                + borrowedBooks + " }";
    }
    

}
