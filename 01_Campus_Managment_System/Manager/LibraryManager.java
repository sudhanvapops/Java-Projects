package Manager;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

import Utils.StudentUtils;
import model.Book;
import model.Library;
import model.ShelfType;
import model.Student;

public class LibraryManager {

    private ArrayList<Student> students;
    private StudentManager sm;
    private Library l1;

    Scanner sc = new Scanner(System.in);

    private static final Map<Integer, ShelfType> shelfDispatcher = Map.of(
            1, ShelfType.MAIN,
            2, ShelfType.BORROWED);

    public LibraryManager(ArrayList<Student> students, StudentManager sm, Library l1) {
        this.sm = sm;
        this.students = students;
        this.l1 = l1;
    }

    // Adding books to main shelf
    public void addBook() {
        System.out.flush();
        System.out.println("Enter the Book Details: ");

        System.out.print("Enter Book id : ");
        String bookId = sc.nextLine();
        System.out.print("Enter Book Title : ");
        String title = sc.nextLine();
        System.out.print("Enter Book author : ");
        String author = sc.nextLine();

        Book book = new Book(bookId, title, author);
        l1.addBook(book);

        // System.out.print("Book Added: "+book);

    }

    // ? Test Function
    public void testAddBook() {
        l1.addBook(new Book("1", "Dune 1", "Sudhanva 1"));
        l1.addBook(new Book("2", "Dune 2", "Sudhanva 2"));
        l1.addBook(new Book("3", "Dune 3", "Sudhanva 3"));
        l1.addBook(new Book("4", "Dune 4", "Sudhanva 4"));
    }

    // ! For all function ID should be numbers not any string

    // Funtion To Remove Book
    public void removeBook() {
        System.out.print("Enter the Id / Title of the book: ");
        String key = sc.nextLine();
        System.out.flush();
        l1.removeBook(key);
    }

    // View All books
    public void viewAllBooks() {
        System.out.println("******************");
        System.out.println("1. View Main Shelf");
        System.out.println("2. View Borrowed Books");
        System.out.println("******************");
        System.out.print("Enter The Choice: ");
        Integer choice = sc.nextInt();
        sc.nextLine();
        System.out.flush();

        ShelfType selectedShelf = shelfDispatcher.get(choice);

        if (selectedShelf == null) {
            System.out.println("Invalid Choice");
            return;
        }

        l1.viewAllBooks(selectedShelf);

    }

    // Boorrow Book
    public void borrowBook() {
        System.out.print("Enter the Id of the student: ");
        String studentId = sc.nextLine().trim();
        Student student = StudentUtils.findStudentById(students, studentId);

        if (student != null) {
            System.out.print("Enter the Id/Title of the book to boorow: ");
            String bookToBorrow = sc.nextLine().trim();

            Book bookBorrowed = l1.borrowBook(bookToBorrow);

            if(bookBorrowed != null){
                student.getBorrowedBooks().add(bookBorrowed);
            }
        }

    }

}
