import java.util.*;
public class Average {
    public static double calculateAverage(int[] arr) {
        if (arr.length == 0) {
            throw new IllegalArgumentException("Array cannot be empty.");
        }

        int sum = 0;
        for (int num : arr) {
            sum += num;
        }
        return (double) sum / arr.length;
    }

    public static void main(String[] args) {
        int[] numbers = {5, 10, 15, 20, 25};
        System.out.printf("Average: %.2f\n", calculateAverage(numbers));
    }
}
