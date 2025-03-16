import java.util.*;
public class FibonacciSeries {
    
           public static void printFibonacci(int terms) {
        if (terms < 1) {
            System.out.println("Number of terms must be at least 1.");
            return;
        }

        int first = 0, second = 1;
        System.out.print("Fibonacci Sequence: " + first);
        
        for (int i = 1; i < terms; i++) {
            System.out.print(" " + second);
            int next = first + second;
            first = second;
            second = next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of terms: ");
        int terms = scanner.nextInt();
        printFibonacci(terms);
        scanner.close();
    }
}
