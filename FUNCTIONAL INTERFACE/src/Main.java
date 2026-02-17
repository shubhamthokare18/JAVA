@FunctionalInterface
interface NumberCalculator {
    int calculateNumber(int number1, int number2);
}
public class Main {
    public static void main(String[] args) {
        NumberCalculator addNumber = ((number1, number2) -> number1 + number2);
        System.out.println("NUMBER SUM: " + addNumber.calculateNumber(10, 20));
        NumberCalculator multiplyNumber = ((number1, number2) -> number1 * number2);
        System.out.println("NUMBER PRODUCT: " + multiplyNumber.calculateNumber(10, 20));
    }
}