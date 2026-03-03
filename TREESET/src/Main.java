//import java.util.Set;
//import java.util.TreeSet;
//
//public class Main {
//
//    public static void main(String[] args) {
//
//        // TreeSet stores elements in sorted (ascending) order
//        Set<Integer> numbers = new TreeSet<>();
//
//        numbers.add(50);
//        numbers.add(40);
//        numbers.add(30);
//        numbers.add(20);
//        numbers.add(10);
//
//        // Printing elements using enhanced for loop
//        for (Integer num : numbers) {
//            System.out.println(num);
//        }
//    }
//}



import java.util.Set;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) {

        // TreeSet stores elements in sorted order (alphabetically for String)
        Set<String> cars = new TreeSet<>();

        cars.add("VOLVO");
        cars.add("MAZDA");
        cars.add("FORD");
        cars.add("BMW");

        // Remove a specific element
        cars.remove("VOLVO");

        // Print size after removal
        System.out.println("Set Size: " + cars.size());

        // Print elements
        for (String car : cars) {
            System.out.println(car);
        }

        // Clear all elements
        cars.clear();
        System.out.println("Set Size after clear: " + cars.size());
    }
}