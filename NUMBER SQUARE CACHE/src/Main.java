import java.util.HashMap;
import java.util.Map;

public class Main {

    // Cache to store computed squares
    private final Map<Integer, Integer> numberSquareCache = new HashMap<>();

    // Method to get square of a number with caching
    public int getNumberSquare(int number) {

        return numberSquareCache.computeIfAbsent(number, key -> {
            System.out.println("Calculating square for: " + key);
            return key * key;
        });
    }

    public static void main(String[] args) {

        Main service = new Main();

        System.out.println("Number: 1 | Square: " + service.getNumberSquare(1));
        System.out.println("Number: 2 | Square: " + service.getNumberSquare(2));

        // This will be fetched from cache
        System.out.println("Number: 2 | Square: " + service.getNumberSquare(2));
    }
}
