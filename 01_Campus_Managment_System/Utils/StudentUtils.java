package Utils;

import java.util.ArrayList;
import java.util.UUID;

import model.Student;

public class StudentUtils {

    public static Student findStudentById(ArrayList<Student> students, String id) {
        for (Student student : students) {
            if (student.getId().equalsIgnoreCase(id))
                return student;
        }
        return null;
    }

    public static Student findStudentByAcc(ArrayList<Student> students, String accNumber) {
        for (Student student : students) {
            if (student.getAccount().getAccountNumber().equalsIgnoreCase(accNumber))
                return student;
        }
        return null;
    }

    public static String generateUniqueId(ArrayList<Student> students) {
        while (true) {
            String id = UUID.randomUUID().toString().substring(0, 8).toUpperCase();
            boolean isUnique = true;

            for (Student s : students) {
                if (s.getAccount().getAccountNumber().equalsIgnoreCase(id) || s.getId().equalsIgnoreCase(id)) {
                    isUnique = false;
                    break;
                }
            }

            if (isUnique) {
                return id;
            }

        }
    }

}
