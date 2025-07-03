package Manager;
import java.util.ArrayList;
import java.util.Scanner;

import Utils.StudentUtils;
import model.Student;


public class BankManager {
    
    private StudentManager sm;
    private ArrayList<Student> students;

    Scanner sc = new Scanner(System.in);

    public BankManager(StudentManager sm ,ArrayList<Student> students){
        this.sm = sm;
        this.students = students;
    }


    public void depositMoney(){
        System.out.print("Enter Student Id: ");
        String id = sc.nextLine().trim();
        Student student = StudentUtils.findStudentById(students, id);

        if(student != null){
            System.out.println("Enter amount to deposit: ");
            double amount = sc.nextDouble();
            student.getAccount().deposit(amount);
        }else{
            System.out.println("Student not Found.");
        }

    }

    

}
