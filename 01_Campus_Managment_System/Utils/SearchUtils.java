package Utils;

import java.util.ArrayList;
import java.util.function.Predicate;

import model.Book;
import model.Student;

public class SearchUtils {

    public static <T> T findByPredicate(ArrayList<T> list, Predicate<T> predicate) {
        return list.stream()
                .filter(predicate)
                .findFirst()
                .orElse(null);
    }

    public static Book findBookByKey(String key, ArrayList<Book> books) {
        String searchKey = key.trim();
        return findByPredicate(books, book -> 
            book.getBookId().equalsIgnoreCase(searchKey) ||
            book.getTitle().equalsIgnoreCase(searchKey)
        );
    }

    public static Student findStudentByKey(String key, ArrayList<Student> students){
        String searchKey = key.trim();
        return findByPredicate(students, student -> 
            student.getId().equalsIgnoreCase(searchKey) ||
            student.getName().equalsIgnoreCase(searchKey) ||
            student.getAccount().getAccountNumber().equalsIgnoreCase(searchKey)
        );
    }

}
