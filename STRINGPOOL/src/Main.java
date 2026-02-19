public class Main {

    public static void main(String[] args) {

        // String literals (stored in String Pool)
        String strA = "STRING";
        String strB = "STRING";
        String strC = "STRING2";

        // String objects (stored in Heap)
        String objA = new String("STRING");
        String objB = new String("STRING");
        String objC = new String("STRING5");

        System.out.println("===== STRING LITERAL COMPARISON =====");
        System.out.println("strA == strB: " + (strA == strB));           // true (same pool reference)
        System.out.println("strA == objA: " + (strA == objA));           // false (pool vs heap)
        System.out.println("strA.equals(strB): " + strA.equals(strB));   // true (value same)
        System.out.println("strA.equals(strC): " + strA.equals(strC));   // false (value different)

        System.out.println("\n===== STRING OBJECT COMPARISON =====");
        System.out.println("objA == objB: " + (objA == objB));           // false (different objects)
        System.out.println("objA.equals(objB): " + objA.equals(objB));   // true (value same)
        System.out.println("objA.equals(objC): " + objA.equals(objC));   // false (value different)
    }
}
