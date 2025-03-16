import java.util.Scanner;
public class ExceptionHandling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter a number: ");
            int num = scanner.nextInt();
            int result = 100 / num; // May cause division by zero
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Error: Cannot divide by zero!");
        } catch (Exception e) {
            System.out.println("Error: Invalid input. Please enter a number.");
        } finally {
            scanner.close();
            System.out.println("Program execution completed.");
        }
    }
}
