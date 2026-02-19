import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);

        System.out.println("Number List: " + numbers);

        // Sum of even numbers using Stream API
        int evenSum = numbers.stream()
                .filter(num -> num % 2 == 0)
                .mapToInt(Integer::intValue)
                .sum();

        System.out.println("Sum of Even Numbers: " + evenSum);
    }
}
