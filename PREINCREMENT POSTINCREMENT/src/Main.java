//public class Main {
//
//    public static void main(String[] args) {
//
//        int number1 = 10;
//        System.out.println("Initial number1: " + number1);
//        System.out.println("Pre Increment (++number1): " + ++number1); // increment first, then use
//
//        int number2 = 10;
//        System.out.println("\nInitial number2: " + number2);
//        System.out.println("Post Increment (number2++): " + number2++); // use first, then increment
//        System.out.println("After Post Increment: " + number2);
//    }
//}



public class Main {

    public static void main(String[] args) {

        int number1 = 10;

        // Pre-increment: increment first, then assign
        int number2 = ++number1;

        // Post-increment: assign first, then increment
        int number3 = number1++;

        System.out.println("Final Values:");
        System.out.println("number1 (after all operations): " + number1);
        System.out.println("number2 (result of ++number1): " + number2);
        System.out.println("number3 (result of number1++): " + number3);
    }
}
