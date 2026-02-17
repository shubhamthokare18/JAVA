public class Main {

    public static void main(String[] args) {

        String string = "STRING";
        String string1 = "STRING";
        String string2 = "STRING2";

        String string3 = new String("STRING");
        String string4 = new String("STRING");
        String string5 = new String("STRING5");

        System.out.println("STRING == STRING1: " + (string == string1));
        System.out.println("STRING == STRING3: " + (string == string3));
        System.out.println("STRING.EQUALS(STRING1): " + string.equals(string1));
        System.out.println("STRING.EQUALS(STRING2): " + string.equals(string2));

        System.out.println("STRING3 == STRING4: " + (string3 == string4));
        System.out.println("STRING3.EQUALS(STRING4): " + string3.equals(string4));
        System.out.println("STRING3.EQUALS(STRING5): " + string3.equals(string5));
    }
}