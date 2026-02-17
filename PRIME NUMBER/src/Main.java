public class Main {
    public static void main(String[] args) {
        for (int i = 2; i <= 100; i++) {
            boolean primeNumber = true;
            for (int j = 2; j <= i/2; j++) {
                if (i % j == 0) {
                    primeNumber = false;
                    break;
                }
            } if (primeNumber) {
                System.out.println("PRIME NUMBER: " + i);
            }
        }
    }
}