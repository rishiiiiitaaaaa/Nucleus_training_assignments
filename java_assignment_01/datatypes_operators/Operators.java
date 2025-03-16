import java.util.*;
public class Operators {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Taking user input
        System.out.print("Enter first number: ");
        int num1 = scanner.nextInt();
        System.out.print("Enter second number: ");
        int num2 = scanner.nextInt();

        // Arithmetic Operators
        System.out.println("\nArithmetic Operations:");
        System.out.println(num1 + " + " + num2 + " = " + (num1 + num2)); // Addition
        System.out.println(num1 + " - " + num2 + " = " + (num1 - num2)); // Subtraction
        System.out.println(num1 + " * " + num2 + " = " + (num1 * num2)); // Multiplication
        System.out.println(num1 + " / " + num2 + " = " + (num1 / num2)); // Division
        System.out.println(num1 + " % " + num2 + " = " + (num1 % num2)); // Modulus

        // Relational Operators
        System.out.println("\nRelational Operations:");
        System.out.println(num1 + " == " + num2 + " : " + (num1 == num2)); // Equal to
        System.out.println(num1 + " != " + num2 + " : " + (num1 != num2)); // Not equal to
        System.out.println(num1 + " > " + num2 + " : " + (num1 > num2));   // Greater than
        System.out.println(num1 + " < " + num2 + " : " + (num1 < num2));   // Less than
        System.out.println(num1 + " >= " + num2 + " : " + (num1 >= num2)); // Greater than or equal to
        System.out.println(num1 + " <= " + num2 + " : " + (num1 <= num2)); // Less than or equal to

        // Logical Operators (assuming both numbers are positive)
        boolean isNum1Positive = num1 > 0;
        boolean isNum2Positive = num2 > 0;

        System.out.println("\nLogical Operations:");
        System.out.println("Both numbers are positive (Checked using AND operator): " + (isNum1Positive && isNum2Positive)); // Logical AND
        System.out.println("At least one number is positive (Checked using OR operator): " + (isNum1Positive || isNum2Positive)); // Logical OR
        scanner.close();
    }
}
