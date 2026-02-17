public class Main {
    public static void main(String[] args) {
        int number = 123456789;
        System.out.println("NUMBER: " + number);
        int numberReverse = 0;
        while (number != 0) {
            int digit = number % 10;
            numberReverse = numberReverse * 10 + digit;
            number /= 10;
        }
        System.out.println("NUMBER REVERSE: " + numberReverse);
    }
}