import java.util.Scanner;

public class Temperature {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Temperature Converter");
        System.out.println("1. Celsius to Fahrenheit");
        System.out.println("2. Fahrenheit to Celsius");
        System.out.print("Enter your choice (1 or 2): ");
        int choice = scanner.nextInt();

        if (choice == 1) {
            System.out.print("Enter temperature in Celsius: ");
            float celsius = scanner.nextFloat();
            float fahrenheit = (celsius * 9 / 5) + 32; // Conversion formula
            System.out.printf("Temperature in Fahrenheit: %.2f F\n", fahrenheit);
        } else if (choice == 2) {
            System.out.print("Enter temperature in Fahrenheit: ");
            float fahrenheit = scanner.nextFloat();
            float celsius = (fahrenheit - 32) * 5 / 9; // Conversion formula
            System.out.printf("Temperature in Celsius: %.2f C\n", celsius);
        } else {
            System.out.println("Invalid choice! Please enter 1 or 2.");
        }
        scanner.close();
    }
}
