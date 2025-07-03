package Utils;

import java.util.ArrayList;

import model.Student;

public class StudentUtils {

    public static Student findStudentById(ArrayList<Student> students, String id) {
        for (Student student : students) {
            if (student.getId().equalsIgnoreCase(id))
                return student;
        }
        return null;
    }

}
