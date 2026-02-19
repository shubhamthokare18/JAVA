public class Main {

    public static void main(String[] args) {

        Integer number1 = -128;
        Integer number2 = 127;

        System.out.println("number1: " + number1);
        System.out.println("number2: " + number2);

        // Reference comparison
        System.out.println("number1 == number2: " + (number1 == number2));

        // Value comparison
        System.out.println("number1.equals(number2): " + number1.equals(number2));
    }
}
