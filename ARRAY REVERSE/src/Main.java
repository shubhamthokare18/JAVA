import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] array = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println("ARRAY: " + Arrays.toString(array));
        for (int i = 0; i < array.length/2; i++) {
            int temporaryNumber = array[i];
            array[i] = array[array.length - 1 - i];
            array[array.length - 1 - i] = temporaryNumber;
        }
        System.out.println("ARRAY REVERSE: " + Arrays.toString(array));
    }
}