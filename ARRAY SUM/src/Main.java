import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        int[] numbers = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

        System.out.println("Array: " + Arrays.toString(numbers));

        int sum = calculateSum(numbers);

        System.out.println("Sum of Array Elements: " + sum);
    }

    // Method to calculate sum
    public static int calculateSum(int[] array) {

        int total = 0;

        for (int num : array) {
            total += num;
        }

        return total;
    }
}
