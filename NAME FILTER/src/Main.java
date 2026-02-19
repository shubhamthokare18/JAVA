import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<String> names = new ArrayList<>();

        names.add("ALICE");
        names.add("BHAVESH");
        names.add("AMIT");
        names.add("CHARLIE");
        names.add("ANKIT");

        System.out.println("Name List: " + names);

        System.out.println("\nNames starting with 'A':");

        for (String name : names) {
            if (name.startsWith("A")) {
                System.out.println(name);
            }
        }
    }
}
