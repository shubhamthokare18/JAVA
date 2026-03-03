//public class Main {
//
//    public static void main(String[] args) {
//
//        int[] numbers = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
//        int target = 7;
//
//        int left = 0;
//        int right = numbers.length - 1;
//        boolean found = false;
//
//        // Two pointer approach (works because array is sorted)
//        while (left <= right) {
//
//            int sum = numbers[left] + numbers[right];
//
//            if (sum == target) {
//                System.out.println("Pair Found: "
//                        + numbers[left] + " + "
//                        + numbers[right] + " = " + target);
//                found = true;
//                break;
//            }
//            else if (sum < target) {
//                left++;   // Move left pointer forward
//            }
//            else {
//                right--;  // Move right pointer backward
//            }
//        }
//
//        if (!found) {
//            System.out.println("No Pair Found");
//        }
//    }
//}



import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) {

        int[] numbers = {4, 1, 6, 3, 9, 2, 5};
        int target = 7;

        Set<Integer> seen = new HashSet<>();
        boolean found = false;

        for (int num : numbers) {

            int complement = target - num;

            if (seen.contains(complement)) {
                System.out.println("Pair Found: "
                        + num + " + " + complement + " = " + target);
                found = true;
                break;
            }

            seen.add(num);
        }

        if (!found) {
            System.out.println("No Pair Found");
        }
    }
}