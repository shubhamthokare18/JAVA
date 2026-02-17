import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> numberList = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
        System.out.println("NUMBER LIST: " + numberList);
        int evenNumberSum = numberList.stream().filter(evenNumber -> evenNumber % 2 == 0).mapToInt(Integer::intValue).sum();
        System.out.println("EVEN NUMBER SUM: " + evenNumberSum);
    }
}