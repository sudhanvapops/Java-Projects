package model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import Utils.LibraryUtils;

public class Library {

    // Shelfs
    private final ArrayList<Book> mainShelf = new ArrayList<>();
    private final ArrayList<Book> borrowedBooks = new ArrayList<>();

    // private helper method
    private Book findBookById(String bookId) {
        return mainShelf.stream()
                .filter(book -> book.getBookId().equalsIgnoreCase(bookId))
                .findFirst()
                .orElse(null);
    }

    // Adding Books to Main Shelf
    public void addBook(Book book) {
        if (book == null) {
            throw new IllegalArgumentException("Book cannot be null");
        }
        if (findBookById(book.getBookId()) != null) {
            throw new IllegalArgumentException("Book with ID " + book.getBookId() + " already exists");
        }
        mainShelf.add(book);
        System.out.println("Book Added: " + book);
    };

    // Removing from Main Shelf List
    public void removeBook(String key) {
        key = key.trim();

        if (key == null || key.isEmpty()) {
            throw new IllegalArgumentException("Search key cannot be Empty");
        }

        Iterator<Book> iterator = mainShelf.iterator();
        while (iterator.hasNext()) {
            Book book = iterator.next();
            if (book.getBookId().equalsIgnoreCase(key) || book.getTitle().equalsIgnoreCase(key)) {
                iterator.remove();
                System.out.println("Book Removed: " + book);
                return;
            }
        }
        System.out.println("Book Not Found: " + key);
    }

    // Geting all the books
    public void viewAllBooks(ShelfType shelfName) {
        ArrayList<Book> shelfToView;

        if (shelfName == ShelfType.MAIN) {
            shelfToView = mainShelf;
        } else if (shelfName == ShelfType.BORROWED) {
            shelfToView = borrowedBooks;
        } else {
            System.out.println("Invalid shelf name. Use 'main' or 'borrowed'.");
            return;
        }

        for (Book book : shelfToView) {
            System.out.println(book);
        }
    }

    // Update Book
    public void updateBook(String key, Scanner sc) {
        Book book = LibraryUtils.findBookBykeyMainShelf(key, mainShelf);

        if (book != null) {
            System.out.println("Enter the Details You want to Update: ");
            System.out.print("Enter Updated Id: ");
            String id = sc.nextLine();
            System.out.print("Enter Updated Author: ");
            String author = sc.nextLine();
            System.out.print("Enter Updated Title: ");
            String Title = sc.nextLine();

            book.setAuthor(author);
            book.setBookId(id);
            book.setTitle(Title);

            System.out.println("Book has been Updated");
            System.out.println(book);

        } else {
            System.out.println("Book Not Found " + key);
        }

    }

    // Checking for availiblity of a book using both title and book id
    public BookResult isBookAvailable(String key) {
        for (Book book : mainShelf) {
            if (book.getBookId().equalsIgnoreCase(key.trim()) || book.getTitle().equalsIgnoreCase(key.trim())) {
                return new BookResult(true, book);
            }
        }
        return new BookResult(false, null);
    }

    // method for boorwoing a book
    public Book borrowBook(String key) {
        key = key.trim();
        BookResult bookObj = isBookAvailable(key);
        if (bookObj.found()) {
            Book book = bookObj.book();
            borrowedBooks.add(book);
            mainShelf.remove(book);
            System.out.println("Book borrowed: " + book.getTitle());
            return book;
        } else {
            System.out.println(key + "Book is Not Available to Borrow ");
            return null;
        }
    };

    // Method for returning a book
    public Book returnBook(String key) {
        key = key.trim();

        Book book = LibraryUtils.findBookBykeyBorrowedBooks(key, borrowedBooks);

        if (book != null) {
            borrowedBooks.remove(book);
            mainShelf.add(book);
            System.out.println("Book Returned: " + book.getTitle());
            return book;
        }
        System.out.println("No borrowed book found with ID or title: " + key);
        return null;
    };

}

// Making a Record for the iSavailable method
record BookResult(boolean found, Book book) {
}
