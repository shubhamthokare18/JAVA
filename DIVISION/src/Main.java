//import java.util.Scanner;
//
//public class Main {
//
//    public static void main(String[] args) {
//
//        Scanner scanner = new Scanner(System.in);
//
//        System.out.print("Enter number 1: ");
//        float number1 = scanner.nextFloat();
//
//        System.out.print("Enter number 2: ");
//        float number2 = scanner.nextFloat();
//
//        if (number2 == 0) {
//            System.out.println("Error: Division by zero is not allowed.");
//        } else {
//            float result = number1 / number2;
//            System.out.println("Division Result: " + result);
//        }
//
//        scanner.close(); // Best practice
//    }
//}



import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number 1: ");
        int number1 = scanner.nextInt();

        System.out.print("Enter number 2: ");
        int number2 = scanner.nextInt();

        try {
            int result = number1 / number2;
            System.out.println("Division Result: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Error: Cannot divide by zero.");
        } finally {
            scanner.close(); // Best practice: close resources
        }
    }
}
