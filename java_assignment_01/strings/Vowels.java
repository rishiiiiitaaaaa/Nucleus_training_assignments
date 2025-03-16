import java.util.Scanner;
public class Vowels{
    public static int countVowels(String str) {
        int count = 0;
        str = str.toLowerCase(); // Convert to lowercase to handle both cases
        for (char ch : str.toCharArray()) {
            if ("aeiou".indexOf(ch) != -1) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();
        System.out.println("Number of vowels: " + countVowels(input));
        scanner.close();
    }
}
