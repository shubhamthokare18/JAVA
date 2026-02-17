//import java.util.Arrays;
//import java.util.List;
//
//public class Main {
//    public static void main(String[] args) {
//        List<Integer> numberList = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
//        System.out.println("NUMBER LIST: " + numberList);
//        System.out.print("EVEN NUMBER: ");
//        numberList.stream().filter(evenNumber -> evenNumber % 2 == 0).forEach(evenNumber -> System.out.print(evenNumber + ", "));
//    }
//}


import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> numberList = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
        System.out.println("NUMBER LIST: " + numberList);
        System.out.println("EVEN NUMBER:");
        numberList.stream().filter(evenNumber -> evenNumber % 2 == 0).forEach(System.out::println);
    }
}