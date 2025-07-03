import java.util.ArrayList;

public class Library {

    // Shelfs
    ArrayList<Book> mainShelf = new ArrayList<>();
    ArrayList<Book> borrowedBooks = new ArrayList<>();

    // Adding Books to Library List
    public void addBook(Book book) {
        mainShelf.add(book);
        // ! And Display Appropraie message afterwrads
    };

    // Removing from Library List
    public void removeBook(Book book) {
        mainShelf.remove(book);
        // ! And Display Appropraie message afterwrads
    };

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

    // Checking for availiblity of a book using both title and book id
    public BookResult isBookAvailable(String key) {
        for (Book book : mainShelf) {
            if (book.bookId.equalsIgnoreCase(key.trim()) || book.title.equalsIgnoreCase(key.trim())) {
                return new BookResult(true, book);
            }
        }
        return new BookResult(false, null);
    }

    // method for boorwoing a book
    public void borrowBook(String key) {
        BookResult bookObj = isBookAvailable(key);
        if (bookObj.found()) {
            Book book = bookObj.book();
            borrowedBooks.add(book);
            mainShelf.remove(book);
            System.out.println("Book borrowed: " + book.title);
        } else {
            System.out.println(key + "Book is Not Available to Borrow ");
        }
    };

    // Method for returning a book
    public void returnBook(String key) {
        key = key.trim();

        for (Book book : borrowedBooks) {
            if (book.bookId.equalsIgnoreCase(key) || book.title.equalsIgnoreCase(key)) {
                borrowedBooks.remove(book);
                mainShelf.add(book);
                System.out.println("Book Returned: " + book.title);
                return;
            }
            System.out.println("No borrowed book found with ID or title: " + key);
        }
    };

}

// Making a Record for the iSavailable method
record BookResult(boolean found, Book book) {}

// enum for viewAllbooks
enum ShelfType {
    MAIN, BORROWED;
}