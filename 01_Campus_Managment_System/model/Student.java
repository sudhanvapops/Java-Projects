package model;

import java.util.ArrayList;

public class Student {

    private String id;
    private String name;
    private String grade;

    private BankAccount account;
    private ArrayList<Book> borrowedBooks = new ArrayList<>();

    // Validation method
    private <T> T validateNotEmpty(T obj, String fieldName) {
        if (obj == null) {
            throw new IllegalArgumentException(fieldName + " cannot be null");
        }
        return obj;
    }

    
    // Gettres
    public ArrayList<Book> getBorrowedBooks() {
        return new ArrayList<>(borrowedBooks);
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getGrade() {
        return grade;
    }

    public BankAccount getAccount() {
        return account;
    }

    // Setters
    public void setId(String id) {
        this.id = validateNotEmpty(id, "ID");
    }
    
    public void setName(String name) {
        this.name = validateNotEmpty(name, "Name");
    }
    
    public void setGrade(String grade) {
        this.grade = validateNotEmpty(grade, "Grade");
    }

    public void setBorrowedBooks(ArrayList<Book> borrowedBooks) {
        this.borrowedBooks = validateNotEmpty(borrowedBooks, "Borrwed Books");
    }

    // Counstructor
    public Student(String id, String name, String grade, BankAccount account) {
        this.id = validateNotEmpty(id, "ID");
        this.name = validateNotEmpty(name, "Name");
        this.grade = validateNotEmpty(grade, "Grade");
        this.account = validateNotEmpty(account, "Bank Account");
        this.borrowedBooks = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Student { id: " + id + ", name: " + name + ", grade: " + grade + ", account: " + account
                + ", borrowedBooks: "
                + borrowedBooks + " }";
    }

}
