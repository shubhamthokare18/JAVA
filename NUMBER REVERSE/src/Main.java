public class Main {

    public static void main(String[] args) {

        int number = 123456789;

        System.out.println("Original Number: " + number);

        int reversedNumber = reverseNumber(number);

        System.out.println("Reversed Number: " + reversedNumber);
    }

    // Method to reverse a number
    public static int reverseNumber(int number) {

        int reversed = 0;
        int temp = number;

        while (temp != 0) {
            int digit = temp % 10;
            reversed = reversed * 10 + digit;
            temp /= 10;
        }

        return reversed;
    }
}
