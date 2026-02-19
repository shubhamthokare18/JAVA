//import java.util.Arrays;
//import java.util.List;
//import java.util.stream.Collectors;
//
//public class Main {
//
//    public static void main(String[] args) {
//
//        List<Integer> numbers = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
//
//        System.out.println("Number List: " + numbers);
//
//        // Filter even numbers using Stream
//        List<Integer> evenNumbers = numbers.stream()
//                .filter(num -> num % 2 == 0)
//                .collect(Collectors.toList());
//
//        System.out.println("Even Numbers: " + evenNumbers);
//    }
//}


import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);

        System.out.println("Number List: " + numbers);
        System.out.println("\nEven Numbers:");

        numbers.stream()
                .filter(num -> num % 2 == 0)
                .forEach(System.out::println);
    }
}
