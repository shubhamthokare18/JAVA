//public class Main {
//    public static void main(String[] args) {
//        String string = "STRING";
//        System.out.println("STRING: " + string);
//        String stringReverse = "";
//        for (int i = string.length() - 1; i >= 0; i--) {
//            stringReverse += string.charAt(i);
//        }
//        System.out.println("STRING REVERSE: " + stringReverse);
//    }
//}



public class Main {
    public static void main(String[] args) {
        String string = "STRING";
        System.out.println("STRING: " + string);
        String stringReverse = "";
        for (int i = 0; i < string.length(); i++) {
            stringReverse = string.charAt(i) + stringReverse;
        }
        System.out.println("STRING REVERSE: " + stringReverse);
    }
}