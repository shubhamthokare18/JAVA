public class Main {

    public static void main(String[] args) {

        int number = 10;
        System.out.println("Initial number: " + number);

        // Pre-increment → increment first, then assign
        int preIncrementResult = ++number;
        System.out.println("\nAfter Pre-Increment (++number):");
        System.out.println("number = " + number);
        System.out.println("preIncrementResult = " + preIncrementResult);

        // Post-increment → assign first, then increment
        int postIncrementResult = number++;
        System.out.println("\nAfter Post-Increment (number++):");
        System.out.println("number = " + number);
        System.out.println("postIncrementResult = " + postIncrementResult);
    }
}
