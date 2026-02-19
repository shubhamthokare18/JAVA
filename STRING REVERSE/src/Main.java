//public class Main {
//
//    public static void main(String[] args) {
//
//        String input = "STRING";
//        System.out.println("Original String: " + input);
//
//        String reversed = reverseString(input);
//        System.out.println("Reversed String: " + reversed);
//    }
//
//    // Method to reverse a string
//    public static String reverseString(String text) {
//
//        StringBuilder reversed = new StringBuilder();
//
//        for (int i = text.length() - 1; i >= 0; i--) {
//            reversed.append(text.charAt(i));
//        }
//
//        return reversed.toString();
//    }
//}



public class Main {

    public static void main(String[] args) {

        String input = "STRING";
        System.out.println("Original String: " + input);

        String reversed = reverseString(input);
        System.out.println("Reversed String: " + reversed);
    }

    // Reverse string by prepending characters
    public static String reverseString(String text) {

        StringBuilder reversed = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            reversed.insert(0, text.charAt(i));
        }

        return reversed.toString();
    }
}
