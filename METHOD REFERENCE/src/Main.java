import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("ALICE", "CHARLIE", "JOHN");
        list.forEach(System.out::println);
        System.out.println("LIST: " + list);
    }
}