@FunctionalInterface
interface NumberCalculator {

    // Single abstract method
    int calculate(int a, int b);
}

public class Main {

    public static void main(String[] args) {

        // Addition using Lambda
        NumberCalculator addition = (a, b) -> a + b;
        System.out.println("Sum: " + addition.calculate(10, 20));

        // Multiplication using Lambda
        NumberCalculator multiplication = (a, b) -> a * b;
        System.out.println("Product: " + multiplication.calculate(10, 20));
    }
}
