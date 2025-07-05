package model;

public class Book {

    private String bookId;
    private String title;
    private String author;

    // Getters
    public String getBookId() {
        return bookId;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    // Setters
    public void setBookId(String bookId) {
        this.bookId =  validateNotEmpty(bookId, "Book ID");
    }

    public void setTitle(String title) {
        this.title = validateNotEmpty(title, "Title");
    }

    public void setAuthor(String author) {
        this.author = validateNotEmpty(author, "Author");
    }


    // Constructor
    public Book(String bookId, String title, String author) {
        this.bookId = validateNotEmpty(bookId, "Book ID");
        this.title = validateNotEmpty(title, "Title");
        this.author = validateNotEmpty(author, "Author");
    }

    // Validation Method
    private String validateNotEmpty(String value, String fieldname) {
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException(fieldname + " cannot be empty");
        }
        return value.trim();
    }

    @Override
    public String toString() {
        return "Book { bookId: " + bookId + ", title: " + title + ", author: " + author + " }";
    }

}