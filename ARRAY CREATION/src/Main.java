import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Taking array size input
        System.out.print("Enter array size: ");
        int size = scanner.nextInt();

        int[] numbers = new int[size];

        // Taking array elements input
        for (int i = 0; i < numbers.length; i++) {
            System.out.print("Enter element " + (i + 1) + ": ");
            numbers[i] = scanner.nextInt();
        }

        // Printing full array
        System.out.println("\nArray: " + Arrays.toString(numbers));

        // Printing elements one by one
        System.out.println("\nArray Elements:");
        for (int num : numbers) {
            System.out.println(num);
        }

        scanner.close(); // Closing scanner (best practice)
    }
}
