package Utils;

import java.util.ArrayList;

import model.Book;

public record LibraryUtils() {

    public static Book findBookBykeyMainShelf(String key, ArrayList<Book> mainShelf) {

        key = key.trim();

        for (Book book : mainShelf) {
            if (book.getBookId().equalsIgnoreCase(key) || book.getTitle().equalsIgnoreCase(key)) {
                return book;
            } 
        }
        return null;
    }
    

    public static Book findBookBykeyBorrowedBooks(String key, ArrayList<Book> borrowedBooks) {

        key = key.trim();

        for (Book book : borrowedBooks) {
            if (book.getBookId().equalsIgnoreCase(key) || book.getTitle().equalsIgnoreCase(key)) {
                return book;
            } 
        }
        return null;
    }

}
