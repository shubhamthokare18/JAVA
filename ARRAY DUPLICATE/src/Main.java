//import java.util.Arrays;
//import java.util.HashSet;
//import java.util.Set;
//
//public class Main {
//    public static void main(String[] args) {
//        int[] intArray = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 2, 4, 6, 8};
//        Set<Integer> uniqueSet = new HashSet<>();
//        Set<Integer> duplicateSet = new HashSet<>();
//        for (int arrayElement : intArray) {
//            if (!uniqueSet.add(arrayElement)) {
//                duplicateSet.add(arrayElement);
//            }
//        }
//        System.out.println("ARRAY: " + Arrays.toString(intArray));
//        System.out.println("ARRAY UNIQUE ELEMENT: " + uniqueSet);
//        System.out.println("ARRAY DUPLICATE ELEMENT: " + duplicateSet);
//    }
//}


//import java.util.Arrays;
//import java.util.HashSet;
//import java.util.Set;
//
//public class Main {
//    public static void main(String[] args) {
//        int[] intArray = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 2, 4, 6, 8};
//        Set<Integer> uniqueSet = new HashSet<>();
//        boolean arrayDuplicateElementFound = false;
//        System.out.println("ARRAY: " + Arrays.toString(intArray));
//        for (int arrayElement : intArray) {
//            if (uniqueSet.contains(arrayElement)) {
//                System.out.println("ARRAY DUPLICATE ELEMENT FOUND: " + arrayElement);
//                arrayDuplicateElementFound = true;
//            }
//            uniqueSet.add(arrayElement);
//        }
//        if (!arrayDuplicateElementFound) {
//            System.out.println("ARRAY DUPLICATE ELEMENT NOT FOUND");
//        }
//    }
//}


import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] intArray = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 2, 4, 6, 8, };
        boolean arrayDuplicateElementFound = false;
        System.out.println("ARRAY: " + Arrays.toString(intArray));
        for (int i = 0; i < intArray.length; i++) {
            for (int j = i + 1; j < intArray.length; j++) {
                if (intArray[i] == intArray[j]) {
                    System.out.println("ARRAY DUPLICATE ELEMENT FOUND: " + intArray[i]);
                    arrayDuplicateElementFound = true;
                }
            }
        }
        if (!arrayDuplicateElementFound) {
            System.out.println("ARRAY DUPLICATE ELEMENT NOT FOUND");
        }
    }
}