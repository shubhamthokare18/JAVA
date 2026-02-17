import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] intArray = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        int arraySum = 0;
        for (int arrayElement : intArray) {
            arraySum += arrayElement;
        }
        System.out.println("ARRAY: " + Arrays.toString(intArray));
        System.out.println("ARRAY ELEMENT SUM: " + arraySum);
    }
}