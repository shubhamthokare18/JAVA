import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<String> names = Arrays.asList("ALICE", "CHARLIE", "JOHN");

        System.out.println("Names (using forEach):");
        names.forEach(System.out::println);

        System.out.println("\nFull List: " + names);
    }
}
