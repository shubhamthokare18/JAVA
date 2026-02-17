//import java.util.Scanner;
//
//public class Main {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        System.out.print("ENTER NUMBER 1: ");
//        float number1 = scanner.nextFloat();
//        System.out.print("ENTER NUMBER 2: ");
//        float number2 = scanner.nextFloat();
//        float divisionResult = number1 / number2;
//        System.out.println("DIVISION RESULT: " + divisionResult);
//    }
//}


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("ENTER NUMBER 1: ");
        int number1 = scanner.nextInt();
        System.out.print("ENTER NUMBER 2: ");
        int number2 = scanner.nextInt();
        try {
            int divisionResult = number1 / number2;
            System.out.println("DIVISION RESULT: " + divisionResult);
        } catch (ArithmeticException arithmeticException) {
            System.out.println("CANNOT DIVIDE BY ZERO");
        }
    }
}