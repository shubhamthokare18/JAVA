import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.print("ENTER ARRAY SIZE: ");
        Scanner scanner = new Scanner(System.in);
        int arraySize = scanner.nextInt();
        int[] intArray = new int[arraySize];
        for (int i = 0; i < intArray.length; i++) {
            System.out.print("ENTER ARRAY ELEMENT: ");
            intArray[i] = scanner.nextInt();
        }
        System.out.println("ARRAY: " + Arrays.toString(intArray));
        System.out.println("ARRAY ELEMENT: ");
        for (int arrayElement : intArray){
            System.out.println(arrayElement);
        }
    }
}