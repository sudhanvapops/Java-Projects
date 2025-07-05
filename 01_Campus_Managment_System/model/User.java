package model;

public class User {

    private String userName;
    private Role role;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public User(String userName,Role role){
        this.userName = userName;
        this.role = role;
    }

    
    
}
