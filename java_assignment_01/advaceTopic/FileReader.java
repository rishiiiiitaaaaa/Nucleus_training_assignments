import java.io.*;
public class FileReader {
    public static void main(String[] args) {
        String fileName = "sample.txt"; // Ensure this file exists in the same directory

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            System.out.println("Reading file contents:");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found!");
        } catch (IOException e) {
            System.out.println("Error: An issue occurred while reading the file.");
        }
    }
}
