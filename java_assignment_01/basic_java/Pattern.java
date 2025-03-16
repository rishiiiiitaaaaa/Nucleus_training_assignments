import java.util.*;
public class Pattern {
        // Function to print a triangle pattern
    public static void printTriangle(int size) {
        System.out.println("\nTriangle Pattern:");
        for (int row = 1; row <= size; row++) {  // Loop for rows
            for (int col = 1; col <= row; col++) {  // Loop for columns
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    // Function to print a square pattern
    public static void printSquare(int size) {
        System.out.println("\nSquare Pattern:");
        for (int row = 1; row <= size; row++) {  // Loop for rows
            for (int col = 1; col <= size; col++) {  // Loop for columns
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Display options to the user
        System.out.println("Pattern Printing Program");
        System.out.println("1. Triangle Pattern");
        System.out.println("2. Square Pattern");
        System.out.print("Enter your choice (1 or 2): ");
        
        int choice = scanner.nextInt();
        // Validate choice
        if (choice != 1 && choice != 2) {
            System.out.println("Invalid choice! Please restart and enter 1 or 2.");
            scanner.close();
            return;  // Exit the program if choice is invalid
        }
        System.out.print("Enter the size of the pattern: ");
        int size = scanner.nextInt();

        // condition to ensure size is valid
        if (size <= 0) {
            System.out.println("Invalid size! Please restart and enter a positive number.");
            scanner.close();
            return;
        }

        // Execute based on choice
        if (choice == 1) {
            printTriangle(size);
        } else {
            printSquare(size);
        }
        scanner.close();
    }
}


    
          
