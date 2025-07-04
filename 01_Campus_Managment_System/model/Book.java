package model;
public class Book {
    
    String bookId;
    String title;
    String author;

    public Book(String bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book { bookId: " + bookId + ", title: " + title + ", author: " + author + " }";
    }

}