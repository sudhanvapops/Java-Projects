package model;
import java.util.ArrayList;

public class Student {

    String id;
    public String getId() {
        return id;
    }

    String name;
    String grade;

    BankAccount account;
    ArrayList<Book> borrowedBooks = new ArrayList<>();
    
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
