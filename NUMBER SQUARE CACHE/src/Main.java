import java.util.HashMap;

public class Main {

    private final HashMap<Integer, Integer> numberSquareCache = new HashMap<>();

    public int getNumberSquare(int number) {

        if (numberSquareCache.containsKey(number)) {
            System.out.println("NUMBER SQUARE CACHE:");
            return numberSquareCache.get(number);

        } else {
            int numberSquare = number * number;
            numberSquareCache.put(number, numberSquare);
            return numberSquare;
        }
    }

    public static void main(String[] args) {

        Main main = new Main();

        System.out.println("NUMBER: 1 SQUARE: " + main.getNumberSquare(1));
        System.out.println("NUMBER: 2 SQUARE: " + main.getNumberSquare(2));
        System.out.println("NUMBER: 2 SQUARE: " + main.getNumberSquare(2));
    }
}