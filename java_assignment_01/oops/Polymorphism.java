import java.util.*;

// Parent class: Student
class Student {
    protected String name;
    protected int rollNumber;
    protected double marks;

    // Constructor
    public Student(String name, int rollNumber, double marks) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.marks = marks;
    }

    // Method Overloading (Compile-time Polymorphism)
    public void displayDetails() {
        System.out.println("\nStudent Details:");
        System.out.println("Name: " + name);
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Marks: " + marks);
    }

    public void displayDetails(boolean showGrades) {
        displayDetails();
        if (showGrades) {
            System.out.println("Grade: " + getGrade());
        }
    }

    // Helper method for grading
    private String getGrade() {
        if (marks >= 90) return "A+";
        if (marks >= 80) return "A";
        if (marks >= 70) return "B";
        if (marks >= 60) return "C";
        return "F";
    }
}

// Child class: GraduateStudent (Method Overriding - Run-time Polymorphism)
class GraduateStudent extends Student {
    private String researchTopic;

    // Constructor
    public GraduateStudent(String name, int rollNumber, double marks, String researchTopic) {
        super(name, rollNumber, marks);
        this.researchTopic = researchTopic;
    }

    // Overriding displayDetails() to include research topic
    @Override
    public void displayDetails() {
        super.displayDetails(); // Call Parent's method
        System.out.println("Research Topic: " + researchTopic);
    }
}

public class Polymorphism {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input for Graduate Student
        System.out.print("Enter Student Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Roll Number: ");
        int rollNumber = scanner.nextInt();

        System.out.print("Enter Marks: ");
        double marks = scanner.nextDouble();
        scanner.nextLine(); // Consume newline

        System.out.print("Enter Research Topic: ");
        String researchTopic = scanner.nextLine();

        // Create objects
        Student student = new Student(name, rollNumber, marks);
        GraduateStudent gradStudent = new GraduateStudent(name, rollNumber, marks, researchTopic);

        // Demonstrating Method Overloading
        System.out.println("\nMethod Overloading:");
        student.displayDetails(false); // No grade displayed
        student.displayDetails(true);  // Grade displayed

        // Demonstrating Method Overriding
        System.out.println("\nMethod Overriding:");
        gradStudent.displayDetails(); // Calls overridden method

        scanner.close();
    }
}
