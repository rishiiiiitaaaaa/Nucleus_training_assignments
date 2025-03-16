import java.util.Arrays;
public class BubbleSort {
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        boolean swapped;
        
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap elements
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break; // Optimization: stops if array is already sorted
        }
    }

    public static void main(String[] args) {
        int[] numbers = {5, 3, 8, 1, 2};
        bubbleSort(numbers);
        System.out.println("Sorted Array: " + Arrays.toString(numbers));
    }
}
