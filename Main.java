import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

// Base Person class
class Person {
    private String name;
    private Date dob;

    // Constructor
    public Person(String name, String dob) throws ParseException {
        this.name = name;
        this.dob = new SimpleDateFormat("dd-MM-yyyy").parse(dob);
    }

    // Function to display person's name
    public void displayName() {
        System.out.println("Name: " + name);
    }

    // Function to display person's age
    public void displayAge() {
        long ageInMillis = new Date().getTime() - dob.getTime();
        long ageInYears = ageInMillis / (1000L * 60 * 60 * 24 * 365);
        System.out.println("Age: " + ageInYears + " years");
    }
}


class Employee extends Person {
    private int empId;
    private double salary;


    public Employee(String name, String dob, int empId, double salary) throws ParseException {
        super(name, dob);  
        this.empId = empId;
        this.salary = salary;
    }

    
    public void displayEmployeeDetails() {
        displayName();  
        displayAge();  
        System.out.println("Employee ID: " + empId);
        System.out.println("Salary: $" + salary);
    }
}

public class Main {
    public static void main(String[] args) {
        try {
            
            Employee emp = new Employee("John Doe", "15-05-1990", 101, 55000.0);
            
            emp.displayEmployeeDetails();
        } catch (ParseException e) {
            System.out.println("Invalid date format");
        }
    }
}