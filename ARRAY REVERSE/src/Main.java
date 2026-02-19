import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        int[] numbers = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

        System.out.println("Original Array: " + Arrays.toString(numbers));

        reverseArray(numbers);

        System.out.println("Reversed Array: " + Arrays.toString(numbers));
    }

    // Method to reverse array in-place
    public static void reverseArray(int[] array) {

        int left = 0;
        int right = array.length - 1;

        while (left < right) {
            int temp = array[left];
            array[left] = array[right];
            array[right] = temp;

            left++;
            right--;
        }
    }
}
