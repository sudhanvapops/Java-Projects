package Data;

import java.util.Map;

import model.Role;
import model.User;

public class UserData {

    public static Map<String, User> userMap = Map.of(
            "admin", new User("admin", Role.ADMIN,"password1"),
            "librarian", new User("librarian", Role.LIBRARIAN,"password2"),
            "student", new User("student", Role.STUDENT,"password3"),
            "bank", new User("bank", Role.BANKMANAGER,"password4"));
}
