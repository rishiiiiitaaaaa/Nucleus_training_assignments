import java.util.*;
// Parent class: Student
class Student {
    // Attributes
    protected String name;
    protected int rollNumber;
    protected double marks;

    // Constructor
    public Student(String name, int rollNumber, double marks) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.marks = marks;
    }

    // Method to display student details
    public void displayDetails() {
        System.out.println("\nStudent Details:");
        System.out.println("Name: " + name);
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Marks: " + marks);
    }
}

// Child class: GraduateStudent (Extends Student)
class GraduateStudent extends Student {
    private String researchTopic;
    private String advisorName;

    // Constructor
    public GraduateStudent(String name, int rollNumber, double marks, String researchTopic, String advisorName) {
        // Call parent class constructor
        super(name, rollNumber, marks);
        this.researchTopic = researchTopic;
        this.advisorName = advisorName;
    }

    // Method to display graduate student details (Overrides Parent Method)
    @Override
    public void displayDetails() {
        super.displayDetails(); // Call parent method
        System.out.println("Research Topic: " + researchTopic);
        System.out.println("Advisor Name: " + advisorName);
    }
}


public class Inheritance{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input for Graduate Student
        System.out.print("Enter Graduate Student Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Roll Number: ");
        int rollNumber = scanner.nextInt();
        
        System.out.print("Enter Marks: ");
        double marks = scanner.nextDouble();
        scanner.nextLine(); // Consume newline

        System.out.print("Enter Research Topic: ");
        String researchTopic = scanner.nextLine();

        System.out.print("Enter Advisor Name: ");
        String advisorName = scanner.nextLine();

        // Create GraduateStudent object
        GraduateStudent gradStudent = new GraduateStudent(name, rollNumber, marks, researchTopic, advisorName);

        // Display details
        gradStudent.displayDetails();

        scanner.close();
    }
}
