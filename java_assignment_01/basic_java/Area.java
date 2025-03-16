import java.util.*; // including java library 
class Area {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose shape (circle, rectangle, triangle): ");
        String shape = scanner.next().toLowerCase();
//using switch case for choosing shapes
        switch (shape) {
            case "circle":
                System.out.print("Enter radius: ");
                double radius = scanner.nextDouble();
                System.out.printf("Area of Circle: %.2f\n", Math.PI * radius * radius);
                break;
            case "rectangle":
                System.out.print("Enter length and width: ");
                double length = scanner.nextDouble();
                double width = scanner.nextDouble();
                System.out.printf("Area of Rectangle: %.2f\n", length * width);
                break;
            case "triangle":
                System.out.print("Enter base and height: ");
                double base = scanner.nextDouble();
                double height = scanner.nextDouble();
                System.out.printf("Area of Triangle: %.2f\n", 0.5 * base * height);
                break;
            default:
                System.out.println("Invalid shape! Please enter circle, rectangle, or triangle.");
        }
        scanner.close();
    }
}
