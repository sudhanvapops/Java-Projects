package model;
public class Book {
    
    private String bookId;
    private String title;
    private String author;

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Book(String bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
    }

    // Validation Method
    private String validateNotEmpty(String value,String fieldname){
        value = value.trim();
        if(value == null || value.isEmpty()){
            throw new IllegalArgumentException(fieldname+" cannot be empty");
        }
        return value;
    }


    @Override
    public String toString() {
        return "Book { bookId: " + bookId + ", title: " + title + ", author: " + author + " }";
    }

}