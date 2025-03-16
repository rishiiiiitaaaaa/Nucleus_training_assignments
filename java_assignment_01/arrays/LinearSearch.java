import java.util.*;

public class LinearSearch {
    
    public static int search(int[] arr, int key) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key) {
                return i; // Return index if found
            }
        }
        return -1; // Return -1 if not found
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Taking input for array size
        System.out.print("Enter the number of elements in the array: ");
        int size = scanner.nextInt();
        int[] numbers = new int[size];

        // Taking array elements as input
        System.out.println("Enter " + size + " elements:");
        for (int i = 0; i < size; i++) {
            numbers[i] = scanner.nextInt();
        }

        // Taking key as input to search
        System.out.print("Enter the element to search: ");
        int key = scanner.nextInt();

        // Searching for the key
        int result = search(numbers, key);

        // Output result
        if (result != -1) {
            System.out.println("Element found at index: " + result);
        } else {
            System.out.println("Element not found.");
        }

        scanner.close(); 
    }
}
