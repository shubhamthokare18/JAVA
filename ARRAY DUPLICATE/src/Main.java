//import java.util.Arrays;
//import java.util.HashSet;
//import java.util.Set;
//
//public class Main {
//
//    public static void main(String[] args) {
//
//        int[] numbers = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 2, 4, 6, 8};
//
//        Set<Integer> uniqueElements = new HashSet<>();
//        Set<Integer> duplicateElements = new HashSet<>();
//
//        // Finding duplicates
//        for (int num : numbers) {
//            if (!uniqueElements.add(num)) {
//                duplicateElements.add(num);
//            }
//        }
//
//        // Output
//        System.out.println("Array: " + Arrays.toString(numbers));
//        System.out.println("Unique Elements: " + uniqueElements);
//        System.out.println("Duplicate Elements: " + duplicateElements);
//    }
//}



//import java.util.Arrays;
//import java.util.HashSet;
//import java.util.Set;
//
//public class Main {
//
//    public static void main(String[] args) {
//
//        int[] numbers = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 2, 4, 6, 8};
//
//        Set<Integer> seenElements = new HashSet<>();
//        Set<Integer> printedDuplicates = new HashSet<>();
//
//        boolean duplicateFound = false;
//
//        System.out.println("Array: " + Arrays.toString(numbers));
//        System.out.println("\nDuplicate Elements:");
//
//        for (int num : numbers) {
//
//            // If element already seen → duplicate
//            if (!seenElements.add(num)) {
//
//                // Print only once
//                if (printedDuplicates.add(num)) {
//                    System.out.println(num);
//                    duplicateFound = true;
//                }
//            }
//        }
//
//        if (!duplicateFound) {
//            System.out.println("No duplicate elements found.");
//        }
//    }
//}



import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        int[] numbers = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 2, 4, 6, 8};

        boolean duplicateFound = false;

        System.out.println("Array: " + Arrays.toString(numbers));
        System.out.println("\nDuplicate Elements:");

        for (int i = 0; i < numbers.length; i++) {

            boolean alreadyPrinted = false;

            // Check if this element was already printed
            for (int k = 0; k < i; k++) {
                if (numbers[i] == numbers[k]) {
                    alreadyPrinted = true;
                    break;
                }
            }

            if (alreadyPrinted) {
                continue;
            }

            // Check duplicates ahead
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] == numbers[j]) {
                    System.out.println(numbers[i]);
                    duplicateFound = true;
                    break;
                }
            }
        }

        if (!duplicateFound) {
            System.out.println("No duplicate elements found.");
        }
    }
}
